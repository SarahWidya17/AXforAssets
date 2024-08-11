package com.example.axforasset;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class HomePage extends AppCompatActivity {
    
    private TextView welcomeText, termsText;
    private Button tabTerms, tabConditions;
    private ViewFlipper carousel;
    private ImageView menuButton;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        welcomeText = findViewById(R.id.welcome_text);
        termsText = findViewById(R.id.terms_text);
        tabTerms = findViewById(R.id.tab_terms);
        tabConditions = findViewById(R.id.tab_conditions);
        menuButton = findViewById(R.id.menu_button);

        carousel = findViewById(R.id.carousel);
        int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

        for (int image : images) {
            ImageView imageObj = new ImageView(this);
            imageObj.setBackgroundResource(image);
            carousel.addView(imageObj);
            carousel.setFlipInterval(3000);
            carousel.setAutoStart(true);
            carousel.setInAnimation(this, R.anim.slide_in_left);
            carousel.setOutAnimation(this, R.anim.slide_out_right);
        }


        gestureDetector = new GestureDetector(this, new SwipeGestureDetector());

        carousel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });



        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        if (username != null) {
            welcomeText.setText("Welcome, " + username);
        }
        termsText.setText("These terms and conditions outline the rules and regulations for the use of AXForAssets's Website, located at AXForAssets.com.\n" +
                "\n" +
                "By accessing this website we assume you accept these terms and conditions. Do not continue to use AXForAssets if you do not agree to take all of the terms and conditions stated on this page.\n" +
                "\n" +
                "The following terminology applies to these Terms and Conditions, Privacy Statement and Disclaimer Notice and all Agreements: \"Client\", \"You\" and \"Your\" refers to you, the person log on this website and compliant to the Company's terms and conditions. \"The Company\", \"Ourselves\", \"We\", \"Our\" and \"Us\", refers to our Company. \"Party\", \"Parties\", or \"Us\", refers to both the Client and ourselves. All terms refer to the offer, acceptance and consideration of payment necessary to undertake the process of our assistance to the Client in the most appropriate manner for the express purpose of meeting the Client's needs in respect of provision of the Company's stated services, in accordance with and subject to, prevailing law of af. Any use of the above terminology or other words in the singular, plural, capitalization and/or he/she or they, are taken as interchangeable and therefore as referring to same.\n" +
                "\n" +
                "Cookies\n" +
                "We employ the use of cookies. By accessing AXForAssets, you agreed to use cookies in agreement with the AXForAssets's Privacy Policy.\n" +
                "\n" +
                "Most interactive websites use cookies to let us retrieve the user's details for each visit. Cookies are used by our website to enable the functionality of certain areas to make it easier for people visiting our website. Some of our affiliate/advertising partners may also use cookies.\n" +
                "\n" +
                "License\n" +
                "Unless otherwise stated, AXForAssets and/or its licensors own the intellectual property rights for all material on AXForAssets. All intellectual property rights are reserved. You may access this from AXForAssets for your own personal use subjected to restrictions set in these terms and conditions.\n" +
                "\n" +
                "You must not:\n" +
                "Republish material from AXForAssets\n" +
                "Sell, rent or sub-license material from AXForAssets\n" +
                "Reproduce, duplicate or copy material from AXForAssets\n" +
                "Redistribute content from AXForAssets\n" +
                "\n" +
                "This Agreement shall begin on the date hereof. Our Terms and Conditions were created with the help of the Free Terms and Conditions Generator.\n" +
                "\n" +
                "Parts of this website offer an opportunity for users to post and exchange opinions and information in certain areas of the website. AXForAssets does not filter, edit, publish or review Comments prior to their presence on the website. Comments do not reflect the views and opinions of AXForAssets,its agents and/or affiliates. Comments reflect the views and opinions of the person who post their views and opinions. To the extent permitted by applicable laws, AXForAssets shall not be liable for the Comments or for any liability, damages or expenses caused and/or suffered as a result of any use of and/or posting of and/or appearance of the Comments on this website.\n" +
                "\n" +
                "AXForAssets reserves the right to monitor all Comments and to remove any Comments which can be considered inappropriate, offensive or causes breach of these Terms and Conditions.\n" +
                "\n" +
                "You warrant and represent that:\n" +
                "You are entitled to post the Comments on our website and have all necessary licenses and consents to do so;\n" +
                "The Comments do not invade any intellectual property right, including without limitation copyright, patent or trademark of any third party;\n" +
                "The Comments do not contain any defamatory, libelous, offensive, indecent or otherwise unlawful material which is an invasion of privacy\n" +
                "The Comments will not be used to solicit or promote business or custom or present commercial activities or unlawful activity.\n" +
                "\n" +
                "You hereby grant AXForAssets a non-exclusive license to use, reproduce, edit and authorize others to use, reproduce and edit any of your Comments in any and all forms, formats or media."); // Replace with your terms text

        tabTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termsText.setText("These terms and conditions outline the rules and regulations for the use of AXForAssets's Website, located at AXForAssets.com.\n" +
                        "\n" +
                        "By accessing this website we assume you accept these terms and conditions. Do not continue to use AXForAssets if you do not agree to take all of the terms and conditions stated on this page.\n" +
                        "\n" +
                        "The following terminology applies to these Terms and Conditions, Privacy Statement and Disclaimer Notice and all Agreements: \"Client\", \"You\" and \"Your\" refers to you, the person log on this website and compliant to the Company's terms and conditions. \"The Company\", \"Ourselves\", \"We\", \"Our\" and \"Us\", refers to our Company. \"Party\", \"Parties\", or \"Us\", refers to both the Client and ourselves. All terms refer to the offer, acceptance and consideration of payment necessary to undertake the process of our assistance to the Client in the most appropriate manner for the express purpose of meeting the Client's needs in respect of provision of the Company's stated services, in accordance with and subject to, prevailing law of af. Any use of the above terminology or other words in the singular, plural, capitalization and/or he/she or they, are taken as interchangeable and therefore as referring to same.\n" +
                        "\n" +
                        "Cookies\n" +
                        "We employ the use of cookies. By accessing AXForAssets, you agreed to use cookies in agreement with the AXForAssets's Privacy Policy.\n" +
                        "\n" +
                        "Most interactive websites use cookies to let us retrieve the user's details for each visit. Cookies are used by our website to enable the functionality of certain areas to make it easier for people visiting our website. Some of our affiliate/advertising partners may also use cookies.\n" +
                        "\n" +
                        "License\n" +
                        "Unless otherwise stated, AXForAssets and/or its licensors own the intellectual property rights for all material on AXForAssets. All intellectual property rights are reserved. You may access this from AXForAssets for your own personal use subjected to restrictions set in these terms and conditions.\n" +
                        "\n" +
                        "You must not:\n" +
                        "Republish material from AXForAssets\n" +
                        "Sell, rent or sub-license material from AXForAssets\n" +
                        "Reproduce, duplicate or copy material from AXForAssets\n" +
                        "Redistribute content from AXForAssets\n" +
                        "\n" +
                        "This Agreement shall begin on the date hereof. Our Terms and Conditions were created with the help of the Free Terms and Conditions Generator.\n" +
                        "\n" +
                        "Parts of this website offer an opportunity for users to post and exchange opinions and information in certain areas of the website. AXForAssets does not filter, edit, publish or review Comments prior to their presence on the website. Comments do not reflect the views and opinions of AXForAssets,its agents and/or affiliates. Comments reflect the views and opinions of the person who post their views and opinions. To the extent permitted by applicable laws, AXForAssets shall not be liable for the Comments or for any liability, damages or expenses caused and/or suffered as a result of any use of and/or posting of and/or appearance of the Comments on this website.\n" +
                        "\n" +
                        "AXForAssets reserves the right to monitor all Comments and to remove any Comments which can be considered inappropriate, offensive or causes breach of these Terms and Conditions.\n" +
                        "\n" +
                        "You warrant and represent that:\n" +
                        "You are entitled to post the Comments on our website and have all necessary licenses and consents to do so;\n" +
                        "The Comments do not invade any intellectual property right, including without limitation copyright, patent or trademark of any third party;\n" +
                        "The Comments do not contain any defamatory, libelous, offensive, indecent or otherwise unlawful material which is an invasion of privacy\n" +
                        "The Comments will not be used to solicit or promote business or custom or present commercial activities or unlawful activity.\n" +
                        "\n" +
                        "You hereby grant AXForAssets a non-exclusive license to use, reproduce, edit and authorize others to use, reproduce and edit any of your Comments in any and all forms, formats or media."); // Replace with your terms text
            }
        });

        tabConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termsText.setText("Hyperlinking to our Content\n" +
                        "\n" +
                        "The following organizations may link to our Website without prior written approval:\n" +
                        "\n" +
                        "Government agencies;\n" +
                        "Search engines;\n" +
                        "News organizations;\n" +
                        "Online directory distributors may link to our Website in the same manner as they hyperlink to the Websites of other listed businesses; and\n" +
                        "System wide Accredited Businesses except soliciting non-profit organizations, charity shopping malls, and charity fundraising groups which may not hyperlink to our Web site.\n" +
                        "\n" +
                        "\n" +
                        "These organizations may link to our home page, to publications or to other Website information so long as the link: (a) is not in any way deceptive; (b) does not falsely imply sponsorship, endorsement or approval of the linking party and its products and/or services; and (c) fits within the context of the linking party's site.\n" +
                        "\n" +
                        "\n" +
                        "We may consider and approve other link requests from the following types of organizations:\n" +
                        "\n" +
                        "commonly-known consumer and/or business information sources;\n" +
                        "dot.com community sites;\n" +
                        "associations or other groups representing charities;\n" +
                        "online directory distributors;\n" +
                        "internet portals;\n" +
                        "accounting, law and consulting firms; and\n" +
                        "educational institutions and trade associations.\n" +
                        "\n" +
                        "\n" +
                        "We will approve link requests from these organizations if we decide that: (a) the link would not make us look unfavorably to ourselves or to our accredited businesses; (b) the organization does not have any negative records with us; (c) the benefit to us from the visibility of the hyperlink compensates the absence of AXForAssets; and (d) the link is in the context of general resource information.\n" +
                        "\n" +
                        "\n" +
                        "These organizations may link to our home page so long as the link: (a) is not in any way deceptive; (b) does not falsely imply sponsorship, endorsement or approval of the linking party and its products or services; and (c) fits within the context of the linking party's site.\n" +
                        "\n" +
                        "\n" +
                        "If you are one of the organizations listed in paragraph 2 above and are interested in linking to our website, you must inform us by sending an e-mail to AXForAssets. Please include your name, your organization name, contact information as well as the URL of your site, a list of any URLs from which you intend to link to our Website, and a list of the URLs on our site to which you would like to link. Wait 2-3 weeks for a response.\n" +
                        "\n" +
                        "\n" +
                        "Approved organizations may hyperlink to our Website as follows:\n" +
                        "\n" +
                        "By use of our corporate name; or\n" +
                        "By use of the uniform resource locator being linked to; or\n" +
                        "By use of any other description of our Website being linked to that makes sense within the context and format of content on the linking party's site.\n" +
                        "\n" +
                        "\n" +
                        "No use of AXForAssets's logo or other artwork will be allowed for linking absent a trademark license agreement.\n" +
                        "\n" +
                        "\n" +
                        "iFrames\n" +
                        "\n" +
                        "Without prior approval and written permission, you may not create frames around our Webpages that alter in any way the visual presentation or appearance of our Website.\n" +
                        "\n" +
                        "\n" +
                        "Content Liability\n" +
                        "\n" +
                        "We shall not be hold responsible for any content that appears on your Website. You agree to protect and defend us against all claims that is rising on your Website. No link(s) should appear on any Website that may be interpreted as libelous, obscene or criminal, or which infringes, otherwise violates, or advocates the infringement or other violation of, any third party rights.\n" +
                        "\n" +
                        "\n" +
                        "Reservation of Rights\n" +
                        "\n" +
                        "We reserve the right to request that you remove all links or any particular link to our Website. You approve to immediately remove all links to our Website upon request. We also reserve the right to amen these terms and conditions and it's linking policy at any time. By continuously linking to our Website, you agree to be bound to and follow these linking terms and conditions.\n" +
                        "\n" +
                        "\n" +
                        "Removal of links from our website\n" +
                        "\n" +
                        "If you find any link on our Website that is offensive for any reason, you are free to contact and inform us any moment. We will consider requests to remove links but we are not obligated to or so or to respond to you directly.\n" +
                        "\n" +
                        "We do not ensure that the information on this website is correct, we do not warrant its completeness or accuracy; nor do we promise to ensure that the website remains available or that the material on the website is kept up to date.\n" +
                        "\n" +
                        "\n" +
                        "Disclaimer\n" +
                        "\n" +
                        "To the maximum extent permitted by applicable law, we exclude all representations, warranties and conditions relating to our website and the use of this website. Nothing in this disclaimer will:\n" +
                        "\n" +
                        "limit or exclude our or your liability for death or personal injury;\n" +
                        "limit or exclude our or your liability for fraud or fraudulent misrepresentation;\n" +
                        "limit any of our or your liabilities in any way that is not permitted under applicable law; or\n" +
                        "exclude any of our or your liabilities that may not be excluded under applicable law.\n" +
                        "\n" +
                        "\n" +
                        "The limitations and prohibitions of liability set in this Section and elsewhere in this disclaimer: (a) are subject to the preceding paragraph; and (b) govern all liabilities arising under the disclaimer, including liabilities arising in contract, in tort and for breach of statutory duty.\n" +
                        "\n" +
                        "\n" +
                        "As long as the website and the information and services on the website are provided free of charge, we will not be liable for any loss or damage of any nature."); // Replace with your conditions text
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                    return true;
                }
            }
            return false;
        }

        private void onSwipeLeft() {
            if (carousel.getDisplayedChild() == carousel.getChildCount() - 1) {
                carousel.setDisplayedChild(0);
            } else {
                carousel.showNext();
            }
            carousel.setInAnimation(HomePage.this, R.anim.slide_in_right);
            carousel.setOutAnimation(HomePage.this, R.anim.slide_out_left);
        }

        private void onSwipeRight() {
            if (carousel.getDisplayedChild() == 0) {
                carousel.setDisplayedChild(carousel.getChildCount() - 1);
            } else {
                carousel.showPrevious();
            }
            carousel.setInAnimation(HomePage.this, R.anim.slide_in_left);
            carousel.setOutAnimation(HomePage.this, R.anim.slide_out_right);
        }
    }

    private void showPopupMenu(View anchorView) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.menu_lightbox, null);

        final PopupWindow popupWindow = new PopupWindow(popupView,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                true);

        // Setting up click listeners for menu items
        popupView.findViewById(R.id.menu_items).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String username = intent1.getStringExtra("USERNAME");
                Intent intent2 = new Intent(HomePage.this, ItemActivity.class);
                intent2.putExtra("USERNAME", username);
                startActivity(intent2);
//                Intent intent = new Intent(HomePage.this, ItemActivity.class);
//                intent.putExtra("USERNAME", username);
//                startActivity(intent);
                popupWindow.dismiss();
            }
        });

        popupView.findViewById(R.id.menu_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String username = intent1.getStringExtra("USERNAME");
                Intent intent2 = new Intent(HomePage.this, Profile.class);
                intent2.putExtra("USERNAME", username);
                startActivity(intent2);

                popupWindow.dismiss();
            }
        });

        popupView.findViewById(R.id.menu_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Logout click

                finish();
                popupWindow.dismiss();
            }
        });

        // Show the popup menu
        popupWindow.showAtLocation(anchorView, Gravity.TOP | Gravity.END, 0, 0);
    }
}
