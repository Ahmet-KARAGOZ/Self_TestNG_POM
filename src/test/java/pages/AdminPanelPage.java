package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminPanelPage extends Base {





    @FindBy(xpath = "//*[@href='#41-dropdown-element']")
    public WebElement leftMenuJobsButtonAdmin; //Elif Admin sol menü içindeki Jobs butonu

    @FindBy(xpath = "//*[@href='https://qa.jobexplorerpro.com/admin/job-types']")
    public WebElement leftMenuJobsJobTypesButtonAdmin; //Elif Admin sol menü içindeki Jobs sekmesinin altında bulunan Job Types butonu

    @FindBy(xpath = "//*[@href='https://qa.jobexplorerpro.com/admin/applicants-ranges']")
    public WebElement leftMenuJobsApplicantsRangesButtonAdmin; //Elif Sol menü içindeki Jobs sekmesinin altında bulunan Applicants Ranges butonu

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailBoxAdmin; //Seher Admin login sayfasında yer alan Email kutusu

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordBoxAdmin; //Seher Admin login sayfasında yer alan Password kutusu

    @FindBy(xpath = "//*[@class='signin']")
    public WebElement signinBoxAdmin; //Seher Admin login sayfasında yer alan Sign In kutusu

    @FindBy(xpath = "//*[@class='hamburger btn-link']")
    public WebElement leftMenuButtonAdmin; //Seher Admin sayfasında bulunan soldaki menüyü açma butonu

    @FindBy(xpath = "//*[@href='#33-dropdown-element']")
    public WebElement leftMenuTaxesButtonAdmin; //Seher Admin sol menü içindeki Taxes butonu

    @FindBy(xpath = "(//*[@class='title'])[24]")
    public WebElement countriesTaxesButtonAdmin; //Seher Admin sol menü içindeki Taxes sekmesinin altında bulunan Countries butonu

    @FindBy(xpath = "(//*[text()='Taxes'])[2]")
    public WebElement taxesInTaxesAltMenusu; //Seher Admin sol menü içindeki Texas altındaki taxes menüsü

    @FindBy(xpath = "(//*[@class='panel-body'])[5]")
    public WebElement countriesTotalPageAdmin; //Seher Admin sol menü içindeki Taxes sekmesinin altında bulunan Countries butonunda açılan
    // ülkelerın görüntüsü(table var kontrol edilecek)

    @FindBy(xpath = "//*[@class='btn btn-warning']")
    public WebElement returnToListCountriesPageAdmin; //Seher Texas Countries sayfası ilk ülke ayrıntısındaki Return To List Butonu

    @FindBy(xpath = "(//*[@class='hidden-xs hidden-sm'])[1]")
    public WebElement ViewButtonCountriesDetailsFirstAdmin; //Seher Admin sol menü içindeki Taxes sekmesinin altında bulunan
    // Countries butonu listedeki ilk ülke View butonu

    @FindBy(xpath = "(//*[@class='title'])[30]")
    public WebElement leftMenuNewsletterEmailsButtonAdmin; //Seher Admin sol menü içindeki Newsletter Emails butonu

    @FindBy(xpath = "//*[@class='show-res']")
    public WebElement newsletterEmailsVisibilityTextAdmin; //Seher Admin sol menü içindeki Newsletter Emails butonunda açılan listenin
    // görüntülenebildiğini gösteren alttaki yazı


    @FindBy(xpath = "//*[@class='btn btn-success btn-add-new']")
    public WebElement newsletterEmailsAddNewButtonAdmin; //Seher Admin sol menü içindeki Newsletter Emails butonuna tıklar açılan sayfada
    // New butonuna tıkayarak yeni abone ekler



    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement newsletterEmailsAddEmailBoxAdmin;  //Seher Admin sol menü içindeki Newsletter Emails butonuna-
    // New butonu- email kutusu


    @FindBy(xpath = "//*[@class='btn btn-primary save']")
    public WebElement newsletterEmailsAddSaveButtonAdmin; //Seher Admin sol menü içindeki Newsletter Emails butonuna- New butonu- Save butonu


    @FindBy(xpath = "(//*[@class='hidden-xs hidden-sm'])[2]")
    public WebElement newsletterEmailsFirstEditButtonAdmin; //Seher Admin  sol menü içindeki Newsletter Emails listesine eklediğim ilk üye-edit butonu

    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement editNewsletterEmailsTextAdmin; //Seher Admin sol menü içindeki Newsletter Emails listesine eklediğim ilk üye-edit sayfasındaolduğunu gösteren yazı

    @FindBy(xpath = "//*[@class='btn btn-primary save']")
    public WebElement editSaveButtonNewsletterAdmin; //Seher Admin eklediği aboneyi düzelttiğinde Save butonuyla değişikliği onaylayan buton

    @FindBy(xpath = "(//*[@class='btn btn-sm btn-danger pull-right delete'])[1]")
    public WebElement newsletterEmailsFirstDeleteButtonAdmin; //Seher Admin sol menü içindeki Newsletter Emails listesine eklediğim ilk üye-delete butonu

    @FindBy(xpath = "(//*[@class='btn btn-danger pull-right delete-confirm'])[1]")
    public WebElement newsletterYesDeleteItButton; //Seher Newsletter eklenen abone delete onay yazısı yes delete it


    @FindBy(xpath = "//*[text()='Money']")
    public WebElement leftMenuMoneyButtonAdmin; // Ismail--> Admin sol menü içindeki Money butonu

    @FindBy(xpath = "(//a[@target='_self'])[18]")
    public WebElement leftMenuMoneySubscribtions; // Ismail--> Admin sol menü içindeki Money butonu altindaki Subscribtions
    @FindBy(xpath = "(//*[@class='panel-body'])[3]")
    public WebElement leftMenuMoneyAltMenu; // Ismail--> Admin sol menü içindeki Money slt menuler

    @FindBy(xpath = "//table[@id='dataTable']/tbody/tr")
    public List<WebElement> leftMenuMoneySubscribtionsList; // Ismail--> Admin sol menü içindeki Money butonu altindaki Subscribtions
    @FindBy(xpath = "//*[@class='btn btn-success btn-add-new']")
    public WebElement leftMenuMoneySubscribtionsAddNewButton; // Ismail--> Admin sol menü içindeki Money butonu altindaki Subscribtionsda bulunan Add New butonu
    @FindBy (xpath = "(//*[@class='form-control'])[1]")
    public WebElement addSubscriptionUserID; // Ismail--> add subscription'da bulunan user id text box   (//*[@class='form-control'])[1]
    @FindBy (xpath = "//*[@class='btn btn-primary save']")
    public WebElement subscriptionSaveButton; // Ismail--> add subscription'da bulunan Save butonu
    @FindBy (xpath = "//div[@class='toast toast-success']")
    public WebElement subscriptionAddSuccess; // Ismail--> add subscription'da basarili bir sekilde kayit yapildigini gosteren text
    @FindBy (xpath = "(//*[@class='btn btn-sm btn-primary pull-right edit'])[1]")
    public WebElement subscriptionEditButton; // Ismail--> subscriptionda bulunan ilk edit butonu
    @FindBy (xpath = "(//*[@class='btn btn-sm btn-danger pull-right delete'])[1]")
    public WebElement subscriptionDeleteButton; // Ismail--> subscriptionda bulunan ilk delete butonu
    @FindBy (xpath = "(//*[@class='btn btn-danger pull-right delete-confirm'])[1]")
    public WebElement subscriptionYesDeleteIsButton; // Ismail--> subscriptionda bulunan ilk yes delete it butonu
    @FindBy (xpath = "//*[text()='Successfully Deleted Subscription']")
    public WebElement subscriptionDeleteSuccess; // Ismail--> add subscription'da basarili bir sekilde kayit yapildigini gosteren text


    @FindBy (xpath = "(//a[@target='_self'])[2]")
    public WebElement lefMenuMedia; // Fatih

    @FindBy (xpath = "//*[text()='Dashboard']")
    public WebElement leftMeneDashboard; // Fatih

    @FindBy (xpath = "//*[@class='page-title']")
    public WebElement leftMenuMediaText; // Fatih

    @FindBy (xpath = "(//*[@class='panel-body'])[1]")
    public WebElement leftMenuJobsAltMenu; // Fatih

    @FindBy (xpath = "(//*[@class='text-truncate max-width-150'])[1]")
    public WebElement usernameUserPage;// Erdil UserPage'de sağ üst kısımdaki kullanıcı adı (dinamik)

    @FindBy (xpath = "(//*[@class='icon voyager-person'])[1]")
    public WebElement leftMenuUserButtonAdmin; //Erdil Admin sol menü içindeki User butonu

    @FindBy (xpath = "(//*[@class='icon voyager-person'])[2]")
    public WebElement leftMenuUsersUsersButtonAdmin; // Erdil Admin sol menü içindeki Users sekmesinin altında bulunan Users butonu

    @FindBy (xpath = "//*[@id=\"dataTable\"]/tbody")
    public WebElement usersTable; // Erdil Users sayfası içindeki users tablosu

    @FindBy (xpath = "//*[@class='btn btn-success btn-add-new']")
    public WebElement usersAddUserButton; // Erdil Users sayfası içindeki Add New butonu

    @FindBy (xpath = "//*[@name='avatar']")
    public WebElement usersFileUploadButton; // Erdil Users içerisindeki Add User sayfasındaki File Upload Butonu

    @FindBy (xpath = "//*[@name='name']")
    public WebElement addUsersNameButton;// Erdil Users içerisindeki Add User sayfasındaki Name Butonu

    @FindBy (xpath = "//*[@name='email']")
    public WebElement addUsersEmailButton;// Erdil Users içerisindeki Add User sayfasındaki Email Butonu

    @FindBy (xpath = "//*[@name='password']")
    public WebElement addUsersPasswordButton;// Erdil Users içerisindeki Add User sayfasındaki Password Butonu

    @FindBy (xpath = "//*[@name='bio']")
    public WebElement addUsersBioButton; // Erdil Users içerisindeki Add User sayfasındaki Bio Butonu

    @FindBy (xpath = "//*[@name='location']")
    public WebElement addUsersLocationButton; // Erdil Users içerisindeki Add User sayfasındaki Location Butonu

    @FindBy (xpath = "//*[@name='website']")
    public WebElement addUserWebsiteButton; // Erdil Users içerisindeki Add User sayfasındaki Website Butonu

    @FindBy(xpath = "//*[@class='select2-selection select2-selection--single']")
    public WebElement addUsersRoleDropdown; // Erdil Users içerisindeki Add User sayfasındaki Role Dropdown menü

    @FindBy (xpath = "(//*[@class='select2-search__field'])[2]")
    public WebElement addUsersRoleDroptownSearchField; // Erdil Users içerisindeki Add User sayfasında Role butonuna tıkladıktan sonra açılan yazı yazılabilen Buton

    @FindBy (xpath = "//*[@class='select2-selection select2-selection--multiple']")
    public WebElement addUsersRolesDropdown; // Erdil Users içerisindeki Add User sayfasındaki Roles Dropdown menü

    @FindBy (xpath = "(//*[@class='select2-search__field'])[1]")
    public WebElement addUsersRolesDropdownSearchField; //// Erdil Users içerisindeki Add User sayfasında Roles butonuna tıkladıktan sonra açılan yazı yazılabilen Buton

    @FindBy (xpath = "(//*[@class='select2-selection__choice__remove'])[1]")
    public WebElement addUsersRolesFirstRoleRemoveButton; // Erdil Users içerisindeki Add User sayfasındaki Roles kısmında girilen rolleri kaldırmak için basılan çarpı Butonu

    @FindBy (xpath = "//*[@name='cover']")
    public WebElement addUsersCoverButton; // Erdil Users içerisindeki Add User sayfasındaki Cover Butonu

    @FindBy (xpath = "(//*[@class='btn btn-default active toggle-off'])[1]")
    public WebElement addUsersPublicProfileButton; // Erdil Users içerisindeki Add User sayfasındaki Public Profile on/off Butonu

    @FindBy (xpath = "//*[@name='billing_address']")
    public WebElement addUsersBillingAddressButton; // Erdil Users içerisindeki Add User sayfasındaki Billing Address Butonu

    @FindBy (xpath = "//*[@name='first_name']")
    public WebElement addUsersFirstNameButton; // Erdil Users içerisindeki Add User sayfasındaki First Name Butonu

    @FindBy (xpath = "//*[@name='last_name']")
    public WebElement addUsersLastNameButton; // Erdil Users içerisindeki Add User sayfasındaki Last Name Butonu

    @FindBy (xpath = "//*[@name='city']")
    public WebElement addUsersCityButton; // Erdil Users içerisindeki Add User sayfasındaki City Butonu

    @FindBy (xpath = "//*[@name='country']")
    public WebElement addUsersCountryButton; // Erdil Users içerisindeki Add User sayfasındaki Country Butonu

    @FindBy (xpath = "//*[@name='state']")
    public WebElement addUsersStateButton; // Erdil Users içerisindeki Add User sayfasındaki State Butonu

    @FindBy (xpath = "//*[@name='postcode']")
    public WebElement addUsersPostCodeButton; // Erdil Users içerisindeki Add User sayfasındaki Postcode Butonu

    @FindBy (xpath = "//*[@name='email_verified_at']")
    public WebElement addUsersEmailVerifiedButton; // Erdil Users içerisindeki Add User sayfasındaki Email Verified Butonu

    @FindBy (xpath = "//*[@name='birthdate']")
    public WebElement addUsersBirthdayButton;//  Erdil Users içerisindeki Add User sayfasındaki Birthday Butonu

    @FindBy (xpath = "//*[@name='identity_verified_at']")
    public WebElement addUsersIDVerifiedButton; // Erdil Users içerisindeki Add User sayfasındaki ID Verified Butonu

    @FindBy (xpath = "//*[@name='auth_provider']")
    public WebElement addUsersAuthProviderButton; // Erdil Users içerisindeki Add User sayfasındaki Auth Provider Butonu

    @FindBy (xpath = "//*[@name='auth_provider_id']")
    public WebElement addUsersAuthProviderIDButton; // Erdil Users içerisindeki Add User sayfasındaki Auth Provider ID Butonu

    @FindBy (xpath = "(//*[@class='btn btn-default active toggle-off'])[2]")
    public WebElement addUsersEnable2faButton; // Erdil Users içerisindeki Add User sayfasındaki Enable 2fa Butonu

    @FindBy (xpath = "//*[@class='btn btn-primary save']")
    public WebElement addUsersSaveButton; // Erdil Users içerisindeki Add User sayfasındaki Save Butonu

    @FindBy (xpath = "//*[@id=\"dataTable\"]//tr[1]/td[4]")
    public WebElement firstUserInTableEmail; // Erdil Users içerisinde açılan tablonun ilk elemanının Email adresi

    @FindBy (xpath = "(//*[@id=\"dataTable\"]//tr[1])//a[@title='Edit']")
    public WebElement firstUserInTableEditButton; // Erdil Users içerisinde açılan tablonun ilk elemanındaki Edit Butonu

    @FindBy (xpath = "(//*[@id=\"dataTable\"]//tr[1])//a[@title='Delete']")
    public WebElement firstUserInTableDeleteButton; // Erdil Users içerisinde açılan tablonun ilk elemanındaki Delete Butonu

    @FindBy (xpath = "//*[@value='Yes, Delete it!']")
    public WebElement deleteUserConfirmButton; // Erdil Users içerisinde açılan tabloda eleman silineceğinde çıkan Delete Confirm Butonu

    @FindBy (xpath = "//*[@class='icon voyager-rocket']")
    public WebElement leftMenuFeaturedCategoriesButton; // Erdil Admin sol menü içindeki Featured Categories Butonu

    @FindBy (xpath = "//*[@class='page-title']")
    public WebElement featuredCategoriesHomePageText; // Erdil Featured Categories sayfasındaki Featured Categories yazısı

    @FindBy (xpath = "//*[@class='table table-hover']")
    public WebElement featuredCategoriesTable; // Erdil Featured Categories sayfasındaki Kategori Tablosu

    @FindBy (xpath = "//*[@class='show-res']")
    public WebElement featuredCategoriesCategoryNumberText; // Erdil Featured Categories sayfasının altındaki görüntülenen kategori sayı yazısı

    @FindBy (xpath = "//*[@class='voyager-plus']")
    public WebElement featuredCategoriesAddCategoryButton; // Erdil Featured Categories sayfasındaki Add Category Butonu

    @FindBy (xpath = "//*[@class='select2-selection__arrow']")
    public WebElement addToCategoryCategoryButton; // Erdil Kategori ekleme sayfasında seçilecek Kategori Butonu

    @FindBy (xpath = "//*[@data-select2-id='11']")
    public WebElement addToFeaturedCategoryToSelectCategory; // Erdil Kategori ekleme sayfasında eklenecek olan Kategorinin (Full-Stack Programming) Butonu

    @FindBy (xpath = "//*[@data-select2-id='15']")
    public WebElement editTestFeaturedCategorySecondSelectCategory; // Erdil Kategori ekleme sayfasında ikinci eklenecek olan Kategorinin (Customer Support) Butonu

    @FindBy (xpath = "//*[@class='form-control']")
    public WebElement addToFeaturedCategoryOrder; // Erdil Kategori ekleme sayfasındaki Order Butonu

    @FindBy (xpath = "//*[@class='btn btn-primary save']")
    public WebElement addToFeaturedCategorySaveButton; // Erdil Kategori ekleme sayfasındaki Save Butonu

    @FindBy (xpath = "//*[@class='toast toast-success']")
    public WebElement succesfullyAddedCategoryText;  // Erdil Featured Categories sayfasında yeni kategori eklendiğinde çıkan Kategori Başarıyla Eklendi Yazısı

    @FindBy (xpath = "//*[text()='Successfully Updated Featured Category']")
    public WebElement successfullyUpdatedCategoryText; // Erdil Featured Categories sayfasında kategori editlendiğinde çıkan Kategori Başarıyla Güncellendi Yazısı

    @FindBy (xpath = "//*[text()='Successfully Deleted Featured Category']")
    public WebElement successfullyDeletedCategoryText; // Erdil Featured Categories sayfasında kategori silindiğinde çıkan Kategori Başarıyla Silindi Yazısı

    @FindBy (xpath = "//*[@id=\"dataTable\"]//tr[1]/td[2]")
    public WebElement firstCategoryInTableCategoryName; // Erdil Featured Categories sayfasındaki tablonun ilk elemanının kategori ismi

    @FindBy (xpath = "(//*[@id='dataTable']//tr[1]/td[5])/*[@class='btn btn-sm btn-primary pull-right edit']")
    public WebElement firstCategoryInTableEditButton; // Erdil Featured Categories sayfasındaki tablonun ilk elemanının Edit butonu
    @FindBy (xpath = "(//*[@id=\"dataTable\"]//tr[1]/td[5])/*[@class='btn btn-sm btn-danger pull-right delete']")
    public WebElement firstCategoryInTableDeleteButton; // Erdil Featured Categories sayfasındaki tablonun ilk elemanının Delete butonu

    @FindBy (xpath = "//*[@value='Yes, Delete it!']")
    public WebElement firstCategoryInTableConfirmDeleteButton; // Erdil Featured Categories sayfasındaki tablonun ilk elemanının Delete butonuna basıldığında çıkan Confirm Delete butonu

    @FindBy (xpath = "//*[@id=\"dataTable\"]//tr[1]/td[3]")
    public WebElement getFirstCategoryInTableCategoryOrder; // Erdil Featured Categories sayfasındaki tablonun ilk elemanının Order yazısı


    @FindBy(xpath = "//*[@class='show-res']")
    public WebElement applicantsRangesShowVisibility; //Elif Applicants Ranges ve Plans sayfasındaki tablonun görüntülenme yazısı

    @FindBy(xpath = "//*[@class='btn btn-success btn-add-new']")
    public WebElement applicantsRangesAddNewButton; //Elif Applicants Ranges sayfasındaki Add New butonu

    @FindBy(xpath = "(//*[@class='form-control'])[1]")
    public WebElement addApplicantsRangesNameBox; //Elif Add Applicants Ranges sayfasındaki Name yazılacak yer

    @FindBy(xpath = "(//*[@class='form-control'])[2]")
    public WebElement addApplicantsRangesMinRangeBox; //Elif Add Applicants Ranges sayfasındaki Min Range yazılacak yer

    @FindBy(xpath = "(//*[@class='form-control'])[3]")
    public WebElement addApplicantsRangesMaxRangeBox; //Elif Add Applicants Ranges sayfasındaki Max Range yazılacak yer

    @FindBy(xpath = "//*[@class='btn btn-primary save']")
    public WebElement addApplicantsRangesSaveButton; //Elif Add Applicants Ranges sayfasındaki Save butonu

    @FindBy(xpath = "(//*[@class='btn btn-sm btn-primary pull-right edit'])[1]")
    public WebElement applicantsRangesFirstRangeEditButton; //Elif Applicants Ranges sayfasında eklenen aralığın Edit butonu

    @FindBy(xpath = "(//*[@class='btn btn-sm btn-danger pull-right delete'])[1]")
    public WebElement applicantsRangesFirstRangeDeleteButton; //Elif Applicants Ranges sayfasında eklenen aralığın Delete butonu

    @FindBy(xpath = "//*[@href='https://qa.jobexplorerpro.com/admin/plans']")
    public WebElement leftMenuPlansButtonAdmin; //Elif Sol menü içindeki Plans butonu


    @FindBy (xpath = "//*[@id='dataTable']/tbody/tr")
    public List<WebElement> featuredCategoryTable; // Erdil Featured Categories sayfasındaki tablodaki tüm satırların listesi


    @FindBy (xpath = "(//a[@target='_self'])[3]")
    public WebElement lefMenuJobs; // Fatih


    @FindBy (xpath = "(//a[@target='_self'])[6]")
    public WebElement leftMenuSkills; // Fatih
    @FindBy (xpath = "//*[@class='page-title']")
    public WebElement skillsPageText; // Fatih

    @FindBy (xpath = "//*[text()='Successfully Deleted Skill']")
    public WebElement skillSuccessDelete; // Fatih

    @FindBy (xpath = "(//*[@class='nav navbar-nav'])[3]")
    public WebElement optionsInUsers; // Erdil Admin sayfasında bulunan soldaki menünün users butonu altındaki seçenekler

    @FindBy (xpath = "//*[@class='show-res']")
    public WebElement countriesUlkeSayisi; // Seher Admin countries ulke sayısı

    @FindBy(xpath = "//*[text()='Showing 1 to 4 of 4 entries']")
    public WebElement addApplicantsRangesNewShowText; //Elif

    @FindBy(xpath = "//a[@href='https://qa.jobexplorerpro.com/admin/contact-messages']")
    public WebElement leftMenuContactMessagesText; // Abdurrahman - Admin sol menü içindeki Contact Messages Yazısı
    //a[@href='https://qa.jobexplorerpro.com/admin/contact-messages']
    //span[text()='Contact Messages']

    @FindBy(xpath = "//*[@id='dataTable'] / tbody / tr / td [1]")
    public WebElement contactMessagesPageEmailColumn; // Abdurrahman - Admin sol menü içinde Contact Messages yazısına tıkladığımızdaki Email Sütunu

    @FindBy(xpath = "//*[@id='dataTable'] / tbody / tr / td [2]")
    public WebElement contactMessagesPageSubjectColumn; // Abdurrahman - Admin sol menü içinde Contact Messages yazısına tıkladığımızdaki Subject Sütunu

    @FindBy(xpath = "//*[@id='dataTable'] / tbody / tr / td [3]")
    public WebElement contactMessagesPageMessageColumn; // Abdurrahman - Admin sol menü içinde Contact Messages yazısına tıkladığımızdaki Message Sütunu

    @FindBy(xpath = "//*[@id='dataTable'] / tbody / tr / td [4]")
    public WebElement contactMessagesPageCreatedAtColumn; // Abdurrahman - Admin sol menü içinde Contact Messages yazısına tıkladığımızdaki Created At Sütunu

    @FindBy(xpath = "//*[@id='dataTable'] / tbody / tr / td [5]")
    public WebElement contactMessagesPageActionsColumn; // Abdurrahman - Admin sol menü içinde Contact Messages yazısına tıkladığımızdaki Actions Sütunu

    @FindBy(xpath = "//*[@id='dataTable'] / tbody / tr [1]")
    public WebElement contactMessagesPageDataTableFirstLine; // Abdurrahman - Admin sol menü içinde Contact Messages yazısına tıkladığımızda mevcut olan Data Table içindeki İlk Satır

    @FindBy(xpath = "(//*[@id='dataTable'] //*[@class='btn btn-sm btn-warning pull-right view'])[1]")
    public WebElement contactMessagesPageFirstViewText; // Abdurrahman - Admin sol menü içinde Contact Messages yazısına tıkladığımızdaki İlk View Yazısı

    @FindBy(xpath = "(//*[@class='panel-body'])[7]")
    public WebElement contactMessagesPageMessageContentAfterViewClick; // Abdurrahman - Admin sol menü içinde sırasıyla Contact Messages -> ve View yazısına tıkladıktan sonra mevcut sayfadaki Mesaj İçeriği

    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement contactMessagesPageContactMessagesText; // Abdurrahman - Admin sol menü içinde Contact Messages yazısına tıkladığımızdaki sayfadaki mevcut Contact Messages Yazısı

    @FindBy(xpath = "//*[@class='show-res']")
    public WebElement contactMessagesPageNumberOfMessagesText; // Abdurrahman - Admin sol menü içinde Contact Messages yazısına tıkladığımızdaki Data Table'ın altındaki mevcut  Mesaj Sayısını Gösteren Yazı

    @FindBy(xpath = "(//*[@class='icon voyager-dollar'])[2]")
    public WebElement leftMenuMoneyTransactions; // Ismail--> Admin sol menü içindeki Money butonu Transactions

    @FindBy(xpath = "//*[@class='icon voyager-receipt']")
    public WebElement leftMenuMoneyInvoices; // Ismail--> Admin sol menü içindeki Money butonu Invoices

    @FindBy(xpath = "//*[@href='https://qa.jobexplorerpro.com/invoices/67']")
    public WebElement invoicesFatura67; //Batuhan -Invoices'de yer alan 67. fatura linki

    @FindBy(xpath = "//*[text()='Apply Messages']")
    public WebElement applyMessagesButton; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü

    @FindBy(xpath = "//*[@class='show-res']")
    public WebElement totalApplyText; //Batuhan	-Admin sol menüsünde yer alan Apply Messages menüsü altındaki Toplam Başvuru yazısı

    @FindBy(xpath = "(//*[@class='btn btn-sm btn-warning pull-right view'])[1]")
    public WebElement firstApplyViewButton; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü altındaki ilk Başvuru Detayı Görüntüleme Butonu

    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement pageTitleApplyViewText; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü altındaki ilk Başvuru Detayı Düzenleme Elementleri

    @FindBy(xpath = "//*[text()='Add New']")
    public WebElement addNewApplyMessagesButton; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü altındaki Add New Butonu

    @FindBy(xpath = "//*[@placeholder='Name']")
    public WebElement addNewNameBox; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü altındaki Add New adımı sonrası Name Box

    @FindBy(xpath = "//*[@placeholder='Email']")
    public WebElement addNewEmailBox; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü altındaki Add New adımı sonrası Email Box

    @FindBy(xpath = "(//*[@placeholder='Email'])[2]")
    public WebElement addNewEmailBox2; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü altındaki Add New adımı sonrası Email Box

    @FindBy(xpath = "//*[@placeholder='Message']")
    public WebElement addNewMessageBox; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü altındaki Add New adımı sonrası Message Box

    @FindBy(xpath = "//*[@placeholder='LinkedIn']")
    public WebElement addNewLinkedInBox; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü altındaki Add New adımı sonrası LinkedIn Box

    @FindBy(xpath = "//*[@placeholder='Skills']")
    public WebElement addNewSkillsBox; //Batuhan -Admin sol menüsünde yer alan Apply Messages menüsü altındaki Add New adımı sonrası Skills Box

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton; //Batuhan -New Apply Save Button

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/div[3]/div[2]/div/div/div/div[1]/table/tbody/tr[1]/td[2]/div")
    public WebElement addApplicantsNewRangeName; //Elif Yeni eklenen aralığın değiştirilen ismi

    @FindBy(xpath = "//*[@class='btn btn-success btn-add-new']")
    public WebElement jobTypesAddButtonAdmin; //Alican - Job Types sekmesindeki yeni Job Types ekleme butonu

    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement jobTypesAddNameBoxAdmin; //Alican - Yeni Job Types ekleme sekmesindeki isim yazılacak alan

    @FindBy(xpath = "//*[@class='btn btn-primary save']")
    public WebElement jobTypesAddNameSaveButtonAdmin; //Alican - Yeni Job Types ekleme sekmesindeki kaydetme butonu

    @FindBy(xpath = "//*[@class='toast-message']")
    public WebElement jobTypesToastMessageTextAdmin; //Alican - Expected Toast Message (Text yazılmalı)

    @FindBy(xpath = "(//*[@class='btn btn-sm btn-warning pull-right view'])[1]")
    public WebElement jobTypesFirstJobViewButtonAdmin; //Alican - Job Types tablosundaki ilk Job Type'ın görüntüleme butonu

    @FindBy(xpath = "(//*[@class='btn btn-sm btn-primary pull-right edit'])[1]")
    public WebElement jobTypesFirstJobEditButtonAdmin; //Alican - Job Types tablosundaki ilk Job Type'ın düzenleme butonu

    @FindBy(xpath = "(//*[@class='btn btn-sm btn-danger pull-right delete'])[1]")
    public WebElement jobTypesFirstJobDeleteButtonAdmin; //Alican - Job Types tablosundaki ilk Job Type'ın silme butonu

    @FindBy(xpath = "(//*[@class='panel-title'])[1]")
    public WebElement jobTypesAddedjobViewingVerificationTextAdmin; //Alican - Job Types tablosuna eklenen yeni Job Type'ın görüntülenebildiğinin testi

    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement jobTypesAddedjobEditingNameBoxAdmin; //Alican - Job Types tablosuna eklenen yeni Job Type'ın isminin güncellenebildiği kutu

    @FindBy(xpath = "//*[@class='btn btn-primary save']")
    public WebElement jobTypesAddedjobEditingSaveBoxAdmin; //Alican - Job Types tablosuna eklenen yeni Job Type'ın güncellemesini kaydetme butonu

    @FindBy(xpath = "//*[@class='btn btn-danger pull-right delete-confirm']")
    public WebElement jobTypesFirstJobDeleteConfirmButtonAdmin; //Alican - Job Types tablosundaki ilk Job Type'ın silme işleminin onay butonu

    //US21 için  aldığım locateler Ahmet

    @FindBy(xpath = "//h1[@class='page-title']")
    public WebElement adminDashboardPlatformStatisticsText; //Ahmet
    @FindBy(xpath = "//*[text()='Last 24 hours']")
    public WebElement adminDashboardLast24HoursText; //Ahmet
    @FindBy(xpath = "//*[text()='Payments']")
    public WebElement adminDashboardPaymentsText;//Ahmet
    @FindBy(xpath = "//*[text()='Content']")
    public WebElement adminDashboardContentText; //Ahmet
    @FindBy(xpath = "//*[text()='New users']")
    public WebElement adminDashboardNewUsersText;  //Ahmet
    @FindBy(xpath = "//*[text()='Users roles']")
    public WebElement adminDashboardUsersRolesText;  //Ahmet
    @FindBy(xpath = "//*[text()='Registered users']")
    public WebElement adminDashboardRegisteredUsersText;  //Ahmet
    @FindBy(xpath = "//input[@name='remember']")
    public WebElement adminDashboardBeniHatirlaCheckBox;  //Ahmet
    @FindBy(xpath = "//label[@for='remember']")
    public WebElement adminDashboardBeniHatirlaYazisi;  //Ahmet

    //US21 Son
    //US25 locateler
    @FindBy(xpath = "//span[@class='icon voyager-categories']")
    public WebElement leftMenuCategoriesIconuAdmin;  //Ahmet
    @FindBy(xpath = "//h1[@class='page-title']")
    public WebElement categoiresSayfaBasligiText;  //Ahmet
    @FindBy(xpath = "//a[@rel='next']")
    public WebElement categoriesNextPageIconu;  //Ahmet
    @FindBy(xpath = "//div[@class='show-res']")
    public WebElement categoriesSonucYazisi;  //Ahmet
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> categoriesTabloSatirlarListesi; //Ahmet
    @FindBy(xpath = "//a[@class='btn btn-success btn-add-new']")
    public WebElement categoriesAddNewButton;  //Ahmet
    @FindBy(xpath = "//input[@name='name']")
    public WebElement addCategoryNameBox; //Ahmet
    @FindBy(xpath = "//input[@name='slogan']")
    public WebElement addCategorySloganBox;  //Ahmet
    @FindBy(xpath = "//input[@name='description']")
    public WebElement addCategoryDescriptionBox;  //Ahmet
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement addCategorySaveButton; //Ahmet
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> categoriesTabloIsimList;  //Ahmet
    @FindBy(xpath = "(//div[@class='panel-body'])[5]")
    public WebElement viewingCategoryNameText;  //Ahmet
    @FindBy(xpath = "//input[@name='name']")
    public WebElement editCategoryNameBox;  //Ahmet
    @FindBy(xpath = "//input[@name='slogan']")
    public WebElement editCategorySloganBox;  //Ahmet
    @FindBy(xpath = "//input[@name='description']")
    public WebElement editCategoryDescritionBox;  //Ahmet
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement editCategorySaveButton;  //Ahmet
    @FindBy(xpath = "//input[@value='Yes, Delete it!']")
    public WebElement categorySilmePopupOnayButton;  //Ahmet

    //us25 son
    //us31
    @FindBy(xpath = "//span[@class='icon voyager-company']")
    public WebElement leftMenuCompaniesButtonAdmin;  //Ahmet
    @FindBy(xpath = "//div[@class='show-res']")
    public WebElement companiesShowingEntryText; //Ahmet
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> companiesTabloSatirlarList; //Ahmet
    @FindBy(xpath = "//a[@rel='next']")
    public WebElement companiesNextPageButton;  //Ahmet
    @FindBy(xpath = "//a[@class='btn btn-success btn-add-new']")
    public WebElement companiesAddNewButonu;  //Ahmet
    @FindBy(xpath = "//input[@name='user_id']")
    public WebElement addCompanyUserIdBox; //Ahmet
    @FindBy(xpath = "//input[@name='name']")
    public WebElement addCompanyNameBox;  //Ahmet
    @FindBy(xpath = "//input[@name='slug']")
    public WebElement addCompanySlugBox;  //Ahmet
    @FindBy(xpath = "//input[@name='hq']")
    public WebElement addCompanyHqBox; //Ahmet
    @FindBy(xpath = "//input[@name='website_url']")
    public WebElement addCompanyWebUrlBox;  //Ahmet
    @FindBy(xpath = "//input[@name='email']")
    public WebElement addCompanyEmailBox;  //Ahmet
    @FindBy(xpath = "//input[@name='description']")
    public WebElement addCompanyDescriptionBox;  //Ahmet
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement addCompanySaveButton;  //Ahmet
    @FindBy(xpath = "//select[@id='search_key']")
    public WebElement companyAranacakBaslikDropdown; //Ahmet
    @FindBy(xpath = "//select[@id='filter']")
    public WebElement companyAramaEsitlemeContainsDropDown;  //Ahmet
    @FindBy(xpath = "//input[@name='s']")
    public WebElement companyAramaSearchTextBox;  //Ahmet
    @FindBy(xpath = "//button[@class='btn btn-info btn-lg']")
    public WebElement companyAramaSearchIcon; //Ahmet
    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> companiesNameList;  //Ahmet
    @FindBy(xpath = "//input[@value='Yes, Delete it!']")
    public WebElement companySilmePopupOnayButton;  //Ahmet

    //US_31 için locatelerin sonu


}
