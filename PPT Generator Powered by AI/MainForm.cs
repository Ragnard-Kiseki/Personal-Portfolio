using System.Diagnostics;
using System.Text.Json;
using Guna.UI2.WinForms;
using Microsoft.Office.Core;
using Microsoft.Office.Interop.PowerPoint;
using PPTGenerator.Connection;
using Application = Microsoft.Office.Interop.PowerPoint.Application;
namespace PPTGenerator
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        static readonly LoadingForm loadingForm = new();
        
        private static async Task PptGenerator(string ApiKey, string pptTitle, string numSlide, string description)
        {
            string layout = "Slide (num):\nTitle:\nContent:";
            var parameters = new
            {
                message = $"Create a PowerPoint. Make sure to append them. We will be using Title and Content in each slide. Make it at least {numSlide} slide. The pattern is {layout}\n{description}",
            };

            string json_parameters = JsonSerializer.Serialize(parameters);
            var connection = new CohereConnection(ApiKey);
            var response = await connection.PostAsync("https://api.cohere.ai/v1/chat", json_parameters);

            response.EnsureSuccessStatusCode();
            var body = await response.Content.ReadAsStringAsync();
            var responseBody = JsonSerializer.Deserialize<ResponseObject>(body);

            if (responseBody != null)
            {
                if (responseBody.text != null)
                {
                    MessageBox.Show($"{pptTitle}.pptx generated succesfuly!", "PPT Generated", MessageBoxButtons.OK);
                    loadingForm.Close();

                    Application pptGen = new()
                    {
                        Visible = MsoTriState.msoTrue
                    };
                    Presentation pptPresentation = pptGen.Presentations.Add();

                    Debug.WriteLine("==========APPENDED==========");

                    string[] pattern = responseBody.text.Split(new[] { "Slide " }, StringSplitOptions.RemoveEmptyEntries);

                    foreach (string matches in pattern)
                    {
                        string[] parts = matches.Split(new[] { "Title:", "Content:" }, StringSplitOptions.RemoveEmptyEntries);

                        if (parts.Length == 3)
                        {
                            int slideNumber = int.Parse(parts[0].Trim().Trim(':'));
                            string slideTitle = parts[1].Trim();
                            string slideContent = parts[2].Trim();

                            Slide slide = pptPresentation.Slides.Add(slideNumber, PpSlideLayout.ppLayoutText);

                            slide.Shapes[1].TextFrame.TextRange.Text = slideTitle;
                            slide.Shapes[2].TextFrame.TextRange.Text = slideContent;

                            Debug.WriteLine($"Slide {slideNumber}");
                            Debug.WriteLine($"Title: {slideTitle}");
                            Debug.WriteLine($"Content: {slideContent}\n");
                        }
                    }

                    string folderPath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "PowerPoint");
                    string filePath = Path.Combine(folderPath, $"{pptTitle}.pptx");

                    if (!Directory.Exists(folderPath))
                    {
                        Directory.CreateDirectory(folderPath);
                    }

                    pptPresentation.SaveAs(filePath, PpSaveAsFileType.ppSaveAsDefault, MsoTriState.msoTrue);

                    //Console.WriteLine($"PowerPoint presentation saved to: {filePath}");
                }
            }
        }

        private async void PPTGenerating(object? sender, EventArgs e)
        {
            await PptGenerator(txtApiKey.Text, txtPptTitle.Text, numSlideCount.Value.ToString(), txtPptDesc.Text);
        }

        private void Guna2Button1_Click1(object? sender, EventArgs e)
        {
            if (sender is Guna2Button)
            {
                loadingForm.Load += PPTGenerating;
                loadingForm.ShowDialog();
            }
        }
    }
}
