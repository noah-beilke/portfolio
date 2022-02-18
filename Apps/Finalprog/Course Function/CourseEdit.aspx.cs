using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
namespace Finalprog.Course_Function

{
    public partial class CourseEdit : System.Web.UI.Page
    {
        public static UserDataClassesDataContext us = new UserDataClassesDataContext();
        protected void Page_Load(object sender, EventArgs e)
        {
            var classResults = us.Classes.Select(x => x.Id);
            foreach (int id in classResults)
            {
                courselist.Items.Add(id.ToString());
            }
        }

        protected void loadInfoBtn_Click(object sender, EventArgs e)
        {

            int courseNum = int.Parse(courselist.Text);

            idTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.Id).FirstOrDefault()).ToString();
            descTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.description).FirstOrDefault()).ToString();
            videoTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.videourl).FirstOrDefault()).ToString();
            profTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.professorName).FirstOrDefault()).ToString();
            nameTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.professorName).FirstOrDefault()).ToString();
            lectureTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.lectureHours).FirstOrDefault()).ToString();
            studentTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.studentNumber).FirstOrDefault()).ToString();
            creditsTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.credits).FirstOrDefault()).ToString();
            zoomTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.zoomLink).FirstOrDefault()).ToString();
            titleTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.courseTitle).FirstOrDefault()).ToString();
            announceTxt.Text = (us.Classes.Where(a => a.Id == courseNum).Select(a => a.announcementMessage).FirstOrDefault()).ToString();
        }

        protected void ChangeInfoBtn_Click(object sender, EventArgs e)
        {
            try
            {
                var toDelete = us.Classes.AsEnumerable().Where(x => x.Id == 1010);
                us.Classes.DeleteOnSubmit((Class)toDelete.FirstOrDefault());
                us.SubmitChanges();
            }
            catch
            {
                errorLbl.Text = "Failed to delete";
                errorLbl.Visible = true;
            }

            try
            {
                if (!us.Classes.Any(x => x.Id == Int32.Parse(idTxt.Text)))
                {
                    string name = null, zoomlink = null, crTitle = null, announceMsg = null;
                    int? lecture = null, studentNum = null, credits = null;

                    if (!nameTxt.Text.Equals(""))
                    {
                        name = nameTxt.Text;
                    }
                    if (!lectureTxt.Text.Equals(""))
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
    }

}