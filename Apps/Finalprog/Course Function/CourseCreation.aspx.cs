using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Finalprog.Course_Function
{
    public partial class CourseCreation : System.Web.UI.Page
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

        protected void submitBtn_Click(object sender, EventArgs e)
        {
            errorLbl.Visible = false;
            successLbl.Visible = false;
            try
            {
                if (!us.Classes.Any(x => x.Id == Int32.Parse(idTxt.Text)))
                {
                    string name = null, zoomlink = null, crTitle = null, announceMsg = null;
                    int? lecture = null, studentNum = null, credits = null;

                    if(!nameTxt.Text.Equals(""))
                    {
                        name = nameTxt.Text;
                    }
                    if(!lectureTxt.Text.Equals(""))
                    {
                        lecture = Int32.Parse(lectureTxt.Text);
                    }
                    if (!studentTxt.Text.Equals(""))
                    {
                        studentNum = Int32.Parse(studentTxt.Text);
                    }
                    if (!creditsTxt.Text.Equals(""))
                    {
                        credits = Int32.Parse(creditsTxt.Text);
                    }
                    if (!zoomTxt.Text.Equals(""))
                    {
                        zoomlink = zoomTxt.Text;
                    }
                    if (!titleTxt.Text.Equals(""))
                    {
                        crTitle = titleTxt.Text;
                    }
                    if (!announceTxt.Text.Equals(""))
                    {
                        announceMsg = announceTxt.Text;
                    }
                    Class cl = new Class
                    {
                        Id = Int32.Parse(idTxt.Text),
                        description = descTxt.Text,
                        videourl = videoTxt.Text,
                        professorName = profTxt.Text,
                        lectureHours = lecture,
                        studentNumber = studentNum,
                        credits = credits,
                        zoomLink = zoomlink,
                        courseTitle = crTitle,
                        announcementMessage = announceMsg
                    };
                    us.Classes.InsertOnSubmit(cl);
                    us.SubmitChanges();
                    successLbl.Text = "Success! Course with ID: " + Int32.Parse(idTxt.Text) + " was added.";
                    successLbl.Visible = true;
                }
                else
                {
                    errorLbl.Text = "Duplicated ID found, please check input ID.";
                    errorLbl.Visible = true;
                }
            }
            catch
            {
                errorLbl.Text = "Invalid input detected, please check input.";
                errorLbl.Visible = true;
            }
        }
    }
}