namespace PPTGenerator
{
    partial class MainForm
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges1 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges2 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges3 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges4 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges5 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges6 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges7 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges8 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges9 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges10 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
            txtApiKey = new Guna.UI2.WinForms.Guna2TextBox();
            lblTitle = new Label();
            guna2ShadowPanel1 = new Guna.UI2.WinForms.Guna2ShadowPanel();
            txtPptTitle = new Guna.UI2.WinForms.Guna2TextBox();
            txtPptDesc = new Guna.UI2.WinForms.Guna2TextBox();
            label2 = new Label();
            btnGenerate = new Guna.UI2.WinForms.Guna2Button();
            numSlideCount = new Guna.UI2.WinForms.Guna2NumericUpDown();
            lblSlideCount = new Label();
            guna2ShadowPanel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)numSlideCount).BeginInit();
            SuspendLayout();
            // 
            // txtApiKey
            // 
            txtApiKey.Anchor = AnchorStyles.None;
            txtApiKey.Animated = true;
            txtApiKey.AutoRoundedCorners = true;
            txtApiKey.BorderColor = Color.FromArgb(166, 177, 225);
            txtApiKey.BorderRadius = 19;
            txtApiKey.CustomizableEdges = customizableEdges1;
            txtApiKey.DefaultText = "Hn5P5Xsmvr2jKXLSV9Ou5X8lSETiujI9IeN3m12w";
            txtApiKey.DisabledState.BorderColor = Color.FromArgb(208, 208, 208);
            txtApiKey.DisabledState.FillColor = Color.FromArgb(226, 226, 226);
            txtApiKey.DisabledState.ForeColor = Color.FromArgb(138, 138, 138);
            txtApiKey.DisabledState.PlaceholderForeColor = Color.FromArgb(138, 138, 138);
            txtApiKey.Enabled = false;
            txtApiKey.FocusedState.BorderColor = Color.FromArgb(220, 214, 247);
            txtApiKey.Font = new Font("Verdana", 9F, FontStyle.Regular, GraphicsUnit.Point, 0);
            txtApiKey.HoverState.BorderColor = Color.FromArgb(220, 214, 247);
            txtApiKey.Location = new Point(100, 125);
            txtApiKey.Margin = new Padding(5, 4, 5, 4);
            txtApiKey.MaxLength = 10000;
            txtApiKey.Name = "txtApiKey";
            txtApiKey.PasswordChar = '●';
            txtApiKey.PlaceholderText = "OpenAI Key: e.g. ab-...xxxx";
            txtApiKey.SelectedText = "";
            txtApiKey.ShadowDecoration.CustomizableEdges = customizableEdges2;
            txtApiKey.Size = new Size(292, 40);
            txtApiKey.TabIndex = 0;
            txtApiKey.TextAlign = HorizontalAlignment.Center;
            txtApiKey.UseSystemPasswordChar = true;
            // 
            // lblTitle
            // 
            lblTitle.Anchor = AnchorStyles.None;
            lblTitle.Font = new Font("Verdana", 24F, FontStyle.Regular, GraphicsUnit.Point, 0);
            lblTitle.ForeColor = Color.WhiteSmoke;
            lblTitle.Location = new Point(0, 0);
            lblTitle.Name = "lblTitle";
            lblTitle.Size = new Size(408, 58);
            lblTitle.TabIndex = 1;
            lblTitle.Text = "PPT Generator";
            lblTitle.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // guna2ShadowPanel1
            // 
            guna2ShadowPanel1.Anchor = AnchorStyles.None;
            guna2ShadowPanel1.BackColor = Color.Transparent;
            guna2ShadowPanel1.Controls.Add(lblTitle);
            guna2ShadowPanel1.FillColor = Color.FromArgb(66, 72, 116);
            guna2ShadowPanel1.Location = new Point(42, 46);
            guna2ShadowPanel1.Name = "guna2ShadowPanel1";
            guna2ShadowPanel1.Radius = 5;
            guna2ShadowPanel1.ShadowColor = Color.Transparent;
            guna2ShadowPanel1.Size = new Size(408, 58);
            guna2ShadowPanel1.TabIndex = 2;
            // 
            // txtPptTitle
            // 
            txtPptTitle.Anchor = AnchorStyles.None;
            txtPptTitle.Animated = true;
            txtPptTitle.AutoRoundedCorners = true;
            txtPptTitle.BorderColor = Color.FromArgb(166, 177, 225);
            txtPptTitle.BorderRadius = 19;
            txtPptTitle.CustomizableEdges = customizableEdges3;
            txtPptTitle.DefaultText = "";
            txtPptTitle.DisabledState.BorderColor = Color.FromArgb(208, 208, 208);
            txtPptTitle.DisabledState.FillColor = Color.FromArgb(226, 226, 226);
            txtPptTitle.DisabledState.ForeColor = Color.FromArgb(138, 138, 138);
            txtPptTitle.DisabledState.PlaceholderForeColor = Color.FromArgb(138, 138, 138);
            txtPptTitle.FocusedState.BorderColor = Color.FromArgb(220, 214, 247);
            txtPptTitle.Font = new Font("Verdana", 9F, FontStyle.Regular, GraphicsUnit.Point, 0);
            txtPptTitle.HoverState.BorderColor = Color.FromArgb(220, 214, 247);
            txtPptTitle.Location = new Point(100, 185);
            txtPptTitle.Margin = new Padding(5, 4, 5, 4);
            txtPptTitle.MaxLength = 9;
            txtPptTitle.Name = "txtPptTitle";
            txtPptTitle.PasswordChar = '\0';
            txtPptTitle.PlaceholderText = "Title";
            txtPptTitle.SelectedText = "";
            txtPptTitle.ShadowDecoration.CustomizableEdges = customizableEdges4;
            txtPptTitle.Size = new Size(292, 40);
            txtPptTitle.TabIndex = 4;
            txtPptTitle.TextAlign = HorizontalAlignment.Center;
            // 
            // txtPptDesc
            // 
            txtPptDesc.Anchor = AnchorStyles.None;
            txtPptDesc.BorderColor = Color.FromArgb(166, 177, 225);
            txtPptDesc.BorderRadius = 5;
            txtPptDesc.CustomizableEdges = customizableEdges5;
            txtPptDesc.DefaultText = "";
            txtPptDesc.DisabledState.BorderColor = Color.FromArgb(208, 208, 208);
            txtPptDesc.DisabledState.FillColor = Color.FromArgb(226, 226, 226);
            txtPptDesc.DisabledState.ForeColor = Color.FromArgb(138, 138, 138);
            txtPptDesc.DisabledState.PlaceholderForeColor = Color.FromArgb(138, 138, 138);
            txtPptDesc.FocusedState.BorderColor = Color.FromArgb(220, 214, 247);
            txtPptDesc.Font = new Font("Segoe UI", 9F);
            txtPptDesc.HoverState.BorderColor = Color.FromArgb(220, 214, 247);
            txtPptDesc.Location = new Point(100, 309);
            txtPptDesc.Multiline = true;
            txtPptDesc.Name = "txtPptDesc";
            txtPptDesc.PasswordChar = '\0';
            txtPptDesc.PlaceholderText = "Description: (e.g. PPT is about...)";
            txtPptDesc.SelectedText = "";
            txtPptDesc.ShadowDecoration.CustomizableEdges = customizableEdges6;
            txtPptDesc.Size = new Size(300, 192);
            txtPptDesc.TabIndex = 5;
            // 
            // label2
            // 
            label2.Anchor = AnchorStyles.None;
            label2.AutoSize = true;
            label2.Font = new Font("Verdana", 8.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label2.Location = new Point(100, 504);
            label2.Name = "label2";
            label2.Size = new Size(90, 13);
            label2.TabIndex = 6;
            label2.Text = "Word Count: 0";
            // 
            // btnGenerate
            // 
            btnGenerate.Anchor = AnchorStyles.None;
            btnGenerate.Animated = true;
            btnGenerate.AutoRoundedCorners = true;
            btnGenerate.BorderRadius = 21;
            btnGenerate.CheckedState.FillColor = Color.FromArgb(37, 40, 65);
            btnGenerate.Cursor = Cursors.Hand;
            btnGenerate.CustomizableEdges = customizableEdges7;
            btnGenerate.DisabledState.BorderColor = Color.DarkGray;
            btnGenerate.DisabledState.CustomBorderColor = Color.DarkGray;
            btnGenerate.DisabledState.FillColor = Color.FromArgb(169, 169, 169);
            btnGenerate.DisabledState.ForeColor = Color.FromArgb(141, 141, 141);
            btnGenerate.FillColor = Color.FromArgb(66, 72, 116);
            btnGenerate.Font = new Font("Verdana", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnGenerate.ForeColor = Color.White;
            btnGenerate.HoverState.FillColor = Color.FromArgb(52, 57, 91);
            btnGenerate.Location = new Point(112, 529);
            btnGenerate.Name = "btnGenerate";
            btnGenerate.ShadowDecoration.CustomizableEdges = customizableEdges8;
            btnGenerate.Size = new Size(280, 45);
            btnGenerate.TabIndex = 7;
            btnGenerate.Text = "GENERATE";
            btnGenerate.Click += Guna2Button1_Click1;
            // 
            // numSlideCount
            // 
            numSlideCount.Anchor = AnchorStyles.None;
            numSlideCount.AutoRoundedCorners = true;
            numSlideCount.BackColor = Color.Transparent;
            numSlideCount.BorderRadius = 19;
            numSlideCount.CustomizableEdges = customizableEdges9;
            numSlideCount.Font = new Font("Verdana", 9F, FontStyle.Regular, GraphicsUnit.Point, 0);
            numSlideCount.ForeColor = Color.FromArgb(125, 137, 149);
            numSlideCount.Location = new Point(236, 245);
            numSlideCount.Maximum = new decimal(new int[] { 10, 0, 0, 0 });
            numSlideCount.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            numSlideCount.Name = "numSlideCount";
            numSlideCount.ShadowDecoration.CustomizableEdges = customizableEdges10;
            numSlideCount.Size = new Size(102, 40);
            numSlideCount.TabIndex = 8;
            numSlideCount.UpDownButtonFillColor = Color.FromArgb(192, 192, 255);
            numSlideCount.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // lblSlideCount
            // 
            lblSlideCount.Anchor = AnchorStyles.None;
            lblSlideCount.AutoSize = true;
            lblSlideCount.Font = new Font("Verdana", 9F);
            lblSlideCount.ForeColor = Color.FromArgb(125, 137, 149);
            lblSlideCount.Location = new Point(159, 245);
            lblSlideCount.MinimumSize = new Size(0, 40);
            lblSlideCount.Name = "lblSlideCount";
            lblSlideCount.Size = new Size(73, 40);
            lblSlideCount.TabIndex = 9;
            lblSlideCount.Text = "Min. Slides";
            lblSlideCount.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // MainForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.Control;
            ClientSize = new Size(484, 586);
            Controls.Add(lblSlideCount);
            Controls.Add(numSlideCount);
            Controls.Add(btnGenerate);
            Controls.Add(label2);
            Controls.Add(txtPptDesc);
            Controls.Add(txtPptTitle);
            Controls.Add(txtApiKey);
            Controls.Add(guna2ShadowPanel1);
            Icon = (Icon)resources.GetObject("$this.Icon");
            MinimumSize = new Size(500, 625);
            Name = "MainForm";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "PPT Generator";
            guna2ShadowPanel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)numSlideCount).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Guna.UI2.WinForms.Guna2TextBox txtApiKey;
        private Label lblTitle;
        private Guna.UI2.WinForms.Guna2ShadowPanel guna2ShadowPanel1;
        private Guna.UI2.WinForms.Guna2TextBox txtPptTitle;
        private Guna.UI2.WinForms.Guna2TextBox txtPptDesc;
        private Label label2;
        private Guna.UI2.WinForms.Guna2Button btnGenerate;
        private Guna.UI2.WinForms.Guna2NumericUpDown numSlideCount;
        private Label lblSlideCount;
    }
}
