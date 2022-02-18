using System;
using System.Windows;
using System.Windows.Forms;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using static Finalprog.WebForm1;
using System.Drawing;
using System.ComponentModel;
using System.Text;
using System.Threading.Tasks;


namespace Finalprog
{
    public partial class REsults : System.Web.UI.Page
    {
        public static UserDataClassesDataContext us = new UserDataClassesDataContext();
        //runs on page load.
        protected void Page_Load(object sender, EventArgs e)
        {
            if (String.IsNullOrWhiteSpace(Login.currentUser))
            {
                Response.Redirect("Login.aspx");
            }

            user eo = (from f in us.users 
                       where f.username == Login.currentUser 
                       select f).SingleOrDefault();
            var role = us.Roles.Where(a => a.Id == eo.RoleID).Select(a => a.Description).FirstOrDefault();

            if (Session["searchTerm"] != null)
            {
                String searchText = Session["searchTerm"].ToString();
                Search(searchText);
            }

            if (eo != null)
            {
                if (role == "Admin")
                {
                    btnAdmin.Visible = true;
                }
            }
        }
        //searches the database according to the search criteria.
        private void Search(string searchText)
        {
            //Returns if searchtext is null
            if (searchText == "") {
                return;
            }

            //declaration of the amount (set to 0 initally) for the amount of classes.
            int i = 0;

            //finds the data set that matches the search requirements.
            UserDataClassesDataContext us = new UserDataClassesDataContext();
            var search = (from c in us.Classes
                          where (c.Id.ToString().Contains(searchText) ||
                          c.professorName.ToString().Contains(searchText) ||
                          c.description.ToString().Contains(searchText))
                          select c).ToList();

            //creating of the tiles.
            foreach (var c in search)
            {
                String CourseID = c.Id.ToString();
                String CourseName = c.courseTitle.ToString();
                String Description = c.description.ToString();
                String ProfessorName = c.professorName.ToString();
                Create_Result(CourseID, CourseName, Description, ProfessorName);
                i++;
            }
        }
        //checks to make sure the search is valid.
        private bool searchCheck(string search)
        {
            if (search != null && !String.IsNullOrWhiteSpace(txtResultsSearch.Text))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        //researches the database for the new search criteria.
        protected void btnResultsSearch_Click(object sender, EventArgs e)
        {
            string searchText = txtResultsSearch.Text;
            bool check = searchCheck(searchText);

            if (check == true)
            {
                Session["searchTerm"] = searchText;
                Response.Redirect("REsults.aspx");
            }
        }
        //creates the result, will run the amount of times equal to the amount of results found.
        private void Create_Result(string CourseID, string CourseName, string Description, string ProfessorName)
        {
            //creates the link button for the link to take you to the course page.
            LinkButton Course_Name = new LinkButton
            {
                ID = "hl_CourseName" + CourseID,
                Text = CourseName + "<br />",
                CssClass = "hyperlink"
            };
            //creates the label for the course ID.
            System.Web.UI.WebControls.Label Course_ID = new System.Web.UI.WebControls.Label
            {
                ID = "lbl_CourseID" + CourseID,
                Text = CourseID + " - ",
                CssClass = "description"
            };
            //creates the label for the professor name.
            System.Web.UI.WebControls.Label professor = new System.Web.UI.WebControls.Label
            {
                ID = "lbl_Professor" + CourseID,
                Text = ProfessorName + " - ",
                CssClass = "description"
            };
            //creates the label for the description
            System.Web.UI.WebControls.Label description = new System.Web.UI.WebControls.Label
            {
                ID = "lbl_Description" + CourseID,
                Text = Description + "<br /><br />",
                CssClass = "description"
            };
            //adds the button click event and adding in the courseID variable to send with it.
            Course_Name.Click += new EventHandler((sender, e) => Button_Click(sender, e, Int32.Parse(CourseID)));
            //adds all of the controls to the page.
            divResults.Controls.Add(Course_Name);
            divResults.Controls.Add(Course_ID);
            divResults.Controls.Add(professor);
            divResults.Controls.Add(description);
        }
        //redirects you to the course page on the click event for the link.
        private void Button_Click(object sender, EventArgs e, int CourseID)
        {
            CoursePage.course = CourseID;
            Response.Redirect("~/Course Function/CoursePage.aspx");
        }
        //redirects to the admin page on click.
        protected void btnAdmin_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/User Function/Admin.aspx");
        }
        //redirects to the user page on click.
        protected void btnUser_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/User Function/UserPage.aspx");
        }
        //logs out the user and redirects them to the login screen.
        protected void btnLogout_Click(object sender, EventArgs e)
        {
            user eo = (from f in us.users 
                       where f.username == Login.currentUser 
                       select f).SingleOrDefault();
            us.SubmitChanges();
            Login.currentUser = "";
            Response.Redirect("~/User Function/Login.aspx");
        }
        //to bypass and error that is thrown when dynamically creating the linkbutton.
        public override void VerifyRenderingInServerForm(System.Web.UI.Control control){/*there should be nothing in this*/}
    }
}