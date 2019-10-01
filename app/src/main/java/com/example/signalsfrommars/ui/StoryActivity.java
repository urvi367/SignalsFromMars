package com.example.signalsfrommars.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.signalsfrommars.R;
import com.example.signalsfrommars.model.Page;
import com.example.signalsfrommars.model.Story;

public class StoryActivity extends AppCompatActivity {

    private Story mStory=new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1, mChoice2;
    private String mName;
    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        mImageView=(ImageView)findViewById(R.id.storyImageView);
        mTextView=(TextView)findViewById(R.id.storyTextView);
        mChoice1=(Button)findViewById(R.id.button1);
        mChoice2=(Button)findViewById(R.id.button2);

        loadPage(0);
    }

    private void loadPage(int choice){

        mCurrentPage=mStory.getPage(choice);

        String pageText=mCurrentPage.getText();
        pageText=String.format(pageText, mName);
        Drawable drawable=getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);
        mTextView.setText(pageText);

        if(mCurrentPage.isLast()){
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else {
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }
    }
}
