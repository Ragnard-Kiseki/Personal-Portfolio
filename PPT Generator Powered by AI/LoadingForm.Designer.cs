namespace PPTGenerator
{
    partial class LoadingForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            Guna.UI2.WinForms.Suite.CustomizableEdges customizableEdges1 = new Guna.UI2.WinForms.Suite.CustomizableEdges();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(LoadingForm));
            prgindGenLoad = new Guna.UI2.WinForms.Guna2ProgressIndicator();
            txtGenLoad = new Label();
            SuspendLayout();
            // 
            // prgindGenLoad
            // 
            prgindGenLoad.AutoStart = true;
            prgindGenLoad.Location = new Point(171, 9);
            prgindGenLoad.Name = "prgindGenLoad";
            prgindGenLoad.ShadowDecoration.CustomizableEdges = customizableEdges1;
            prgindGenLoad.Size = new Size(40, 40);
            prgindGenLoad.TabIndex = 1;
            // 
            // txtGenLoad
            // 
            txtGenLoad.AutoSize = true;
            txtGenLoad.Font = new Font("Verdana", 12F, FontStyle.Italic, GraphicsUnit.Point, 0);
            txtGenLoad.Location = new Point(12, 9);
            txtGenLoad.MinimumSize = new Size(0, 40);
            txtGenLoad.Name = "txtGenLoad";
            txtGenLoad.Size = new Size(153, 40);
            txtGenLoad.TabIndex = 2;
            txtGenLoad.Text = "Generating PPT...";
            txtGenLoad.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // LoadingForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(228, 61);
            ControlBox = false;
            Controls.Add(txtGenLoad);
            Controls.Add(prgindGenLoad);
            FormBorderStyle = FormBorderStyle.FixedDialog;
            Icon = (Icon)resources.GetObject("$this.Icon");
            MaximizeBox = false;
            MinimizeBox = false;
            Name = "LoadingForm";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Generating PPT...";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Guna.UI2.WinForms.Guna2ProgressIndicator prgindGenLoad;
        private Label txtGenLoad;
    }
}