using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Finalprog.Course_Function
{
    public partial class CourseAdmin : System.Web.UI.Page
    {
        public static UserDataClassesDataContext us = new UserDataClassesDataContext();
        public static Int32 course;
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnLogout_Click(object sender, EventArgs e)
        {
            user eo = (from f in us.users
                       where f.username == Login.currentUser
                       select f).SingleOrDefault();

            us.SubmitChanges();
            Login.currentUser = "";
            Response.Redirect("~/User Function/Login.aspx");
        }

        protected void btnAdmin_Click(object sender, EventArgs e)
        {

            Response.Redirect("~/User Function/Admin.aspx");

        }

        protected void btnUser_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/User Function/UserPage.aspx");
        }

        protected void btnCourse_Click(object sender, EventArgs e)
        {
            Response.Redirect("CourseCreation.aspx");
        }

        protected void btnQuiz_Click(object sender, EventArgs e)
        {
            Response.Redirect("QuizCreation.aspx");
        }

        protected void btnCourseEdit_Click(object sender, EventArgs e)
        {
            Response.Redirect("CourseEdit.aspx");
        }

        protected void btnQuizEdit_Click(object sender, EventArgs e)
        {
            Response.Redirect("QuizEdit.aspx");
        }
    }
}