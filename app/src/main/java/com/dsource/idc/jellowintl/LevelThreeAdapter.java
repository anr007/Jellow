package com.dsource.idc.jellowintl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dsource.idc.jellowintl.TalkBack.TalkbackHints_SingleClick;
import com.dsource.idc.jellowintl.utility.SessionManager;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Sumeet on 19-04-2016.
 */
class LevelThreeAdapter extends android.support.v7.widget.RecyclerView.Adapter<LevelThreeAdapter.MyViewHolder>{
    private Context mContext;
    private SessionManager mSession;
    private ArrayList<String> mIconList = new ArrayList<>();
    private ArrayList<String> mBelowTextList = new ArrayList<>();
    private String path;

    LevelThreeAdapter(Context context, int levelOneItemPos, int levelTwoItemPos, int sort[]){
        mContext = context;
        mSession = new SessionManager(mContext);
        loadArraysFromResources(levelOneItemPos, levelTwoItemPos, sort);
        File en_dir = mContext.getDir(mSession.getLanguage(), Context.MODE_PRIVATE);
        path = en_dir.getAbsolutePath()+"/drawables";
    }

    @Override
    public LevelThreeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final int GRID_1BY3 = 0;
        View rowView;
        if (mSession.getGridSize() == GRID_1BY3)
            rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_level_xadapter_3_icons, parent, false);
        else
            rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_level_xadapter_9_icons, parent, false);
        return new LevelThreeAdapter.MyViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        ViewCompat.setAccessibilityDelegate(holder.menuItemLinearLayout,
                new TalkbackHints_SingleClick());

        final int MODE_PICTURE_ONLY = 1;
        if (mSession.getPictureViewMode() == MODE_PICTURE_ONLY)
            holder.menuItemBelowText.setVisibility(View.INVISIBLE);
        holder.menuItemBelowText.setText(mBelowTextList.get(position));
        GlideApp.with(mContext)
                .load(path+"/"+ mIconList.get(position)+".png")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(false)
                .centerCrop()
                .dontAnimate()
                .into(holder.menuItemImage);
        holder.menuItemLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                ((LevelThreeActivity)mContext).tappedCategoryItemEvent(holder.menuItemLinearLayout, v, position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mIconList.size();
    }

    private void loadArraysFromResources(int levelOneItemPos, int levelTwoItemPos, int[] sort) {
        if (levelOneItemPos == 0) {
            switch(levelTwoItemPos){
                case 0: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeGreetFeelGreetingIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeGreetFeelGreetingAdapterText), sort);
                    break;
                case 1: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeGreetFeelFeelingIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeGreetFeelFeelingsAdapterText), sort);
                    break;
                case 2: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeGreetFeelRequestsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeGreetFeelRequestsAdapterText), sort);
                    break;
                case 3: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeGreetFeelQuestionsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeGreetFeelQuestionsAdapterText), sort);
                    break;
            }
        } else if (levelOneItemPos == 1) {
            switch(levelTwoItemPos){
                case 3: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActClothesIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActClothesAccAdapterText), sort);
                    break;
                case 4: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActGetReadyIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActGetReadyAdapterText), sort);
                    break;
                case 5: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActSleepIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActSleepAdapterText), sort);
                    break;
                case 6: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActTherapyIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActTherapyAdapterText), sort);
                    break;
                case 9: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActHabitsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeDailyActHabitsAdapterText), sort);
                    break;
            }
        } else if (levelOneItemPos == 2) {
            switch(levelTwoItemPos) {
                case 0: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksBreakfastIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksBreakfastAdapterText), sort);
                    break;
                case 1: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksLunchDinIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksLunchDinnerAdapterText), sort);
                    break;
                case 2: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksSweetsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksSweetsAdapterText), sort);
                    break;
                case 3: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksSnacksIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksSnacksAdapterText), sort);
                    break;
                case 4: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksFruitsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksFruitsAdapterText), sort);
                    break;
                case 5: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksDrinksIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksDrinksAdapterText), sort);
                    break;
                case 6: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksCutleryIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksCutleryAdapterText), sort);
                    break;
                case 7: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksAddonsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFoodDrinksAddonAdapterText), sort);
                    break;
            }
        } else if (levelOneItemPos == 3) {
            switch(levelTwoItemPos){
                case 0: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFunInDGamesIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFunInDGamesAdapterText), sort);
                    break;
                case 1: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFunOutDGamesIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFunOutDGamesAdapterText), sort);
                    break;
                case 2: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFunSportsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFunSportsAdapterText), sort);
                    break;
                case 3: loadAdapterMenuTextIconsWithoutSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFunTvIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFunTvAdapterText));
                    break;
                case 4: loadAdapterMenuTextIconsWithoutSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFunMusicIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFunMusicAdapterText));
                    break;
                case 5: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeFunActivitiesIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeFunActivitiesAdapterText), sort);
                    break;
            }
        } else if (levelOneItemPos == 4) {
            switch(levelTwoItemPos) {
                case 0: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningAnimBirdsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningAnimBirdsAdapterText), sort);
                    break;
                case 1: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningBodyPartsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningBodyPartsAdapterText), sort);
                    break;
                case 2: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningBooksIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningBooksAdapterText), sort);
                    break;
                case 3: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningColorsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningColorsAdapterText), sort);
                    break;
                case 4: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningShapesIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningShapesAdapterText), sort);
                    break;
                case 5: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningStationaryIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningStationaryAdapterText), sort);
                    break;
                case 6: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningSchoolIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningSchoolObjAdapterText), sort);
                    break;
                case 7: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningHomeIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningHomeObjAdapterText), sort);
                    break;
                case 8: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningTransportationIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningTransportAdapterText), sort);
                    break;
                case 9: loadAdapterMenuTextIconsWithoutSort(mContext.getResources().getStringArray(R.array.arrLevelThreeLearningMoneyIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeLearningMoneyAdapterText));
                    break;
            }
        }else if (levelOneItemPos == 6) {
            switch(levelTwoItemPos) {
                case 0: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesMyHouseIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesMyHouseAdapterText), sort);
                    break;
                case 1: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesSchoolIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesSchoolAdapterText), sort);
                    break;
                case 2: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesMallIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesMallAdapterText), sort);
                    break;
                case 3: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesMuseumIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesMuseumAdapterText), sort);
                    break;
                case 4: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesRestaurantIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesRestaurantAdapterText), sort);
                    break;
                case 5: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesTheatreIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesTheatreAdapterText), sort);
                    break;
                case 6: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesPlaygroundIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesPlaygroundAdapterText), sort);
                    break;
                case 7: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesParkIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesParkAdapterText), sort);
                    break;
                case 8: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesStoreIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesStoreAdapterText), sort);
                    break;
                case 9: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesFriendHouseIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesFriendHouseAdapterText), sort);
                    break;
                case 10: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesRelativeHouseIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesRelativeHouseAdapterText), sort);
                    break;
                case 11: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesHospitalIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesHospitalAdapterText), sort);
                    break;
                case 12: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesClinicIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesClinicAdapterText), sort);
                    break;
                case 13: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesLibraryIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesLibraryAdapterText), sort);
                    break;
                case 14: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesZooIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesZooAdapterText), sort);
                    break;
                case 15: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreePlacesWorshipIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreePlacesWorshipAdapterText), sort);
                    break;
            }
        } else if (levelOneItemPos == 7) {
            switch(levelTwoItemPos) {
                case 0: loadAdapterMenuTextIconsWithoutSort(mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaTimeIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaTimeAdapterText));
                    break;
                case 1: loadAdapterMenuTextIconsWithoutSort(mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaDayIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaDayAdapterText));
                    break;
                case 2: loadAdapterMenuTextIconsWithoutSort(mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaMonthIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaMonthAdapterText));
                    break;
                case 3: loadAdapterMenuTextIconsWithoutSort(mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaWeatherIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaWeatherAdapterText));
                    break;
                case 4: loadAdapterMenuTextIconsWithoutSort(mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaSeasonsIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaSeasonsAdapterText));
                    break;
                case 5: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaHoliFestIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaHoliFestAdapterText), sort);
                    break;
                case 6: loadAdapterMenuTextIconsWithSort(mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaBirthdaysIconAdapter),
                        mContext.getResources().getStringArray(R.array.arrLevelThreeTimeWeaBirthdaysAdapterText), sort);
                    break;
            }
        }
    }

    private void loadAdapterMenuTextIconsWithoutSort(String[] typeIconArray, String[] stringBelowTextArray) {
        ArrayList<String> tempIconArr = new ArrayList<>();
        ArrayList<String> tempBelowTextArr = new ArrayList<>();

        for (int j = 0; j < typeIconArray.length; j++) {

            tempIconArr.add(typeIconArray[j]);
            tempBelowTextArr.add(stringBelowTextArray[j]);
        }
        mIconList = tempIconArr;
        mBelowTextList = tempBelowTextArr;
    }

    private void loadAdapterMenuTextIconsWithSort(String[] typeIconArray, String[] stringBelowTextArray, int[] sort) {

        ArrayList<String> tempIconArr = new ArrayList<>();
        ArrayList<String> tempBelowTextArr = new ArrayList<>();
        for (int j = 0; j < typeIconArray.length; j++) {

            tempIconArr.add(typeIconArray[sort[j]]);
            tempBelowTextArr.add(stringBelowTextArray[sort[j]]);
        }
        mIconList = tempIconArr;
        mBelowTextList = tempBelowTextArr;
    }

    class MyViewHolder extends RecyclerView.ViewHolder  {
        private LinearLayout menuItemLinearLayout;
        private ImageView menuItemImage;
        private TextView menuItemBelowText;

        MyViewHolder(final View view) {
            super(view);
            menuItemImage = view.findViewById(R.id.icon1);
            menuItemLinearLayout = view.findViewById(R.id.linearlayout_icon1);
            menuItemBelowText = view.findViewById(R.id.te1);
            menuItemBelowText.setTextColor(Color.rgb(64, 64, 64));
            GradientDrawable gd = (GradientDrawable) view.findViewById(R.id.borderView).getBackground();
            gd.setColor(ContextCompat.getColor(mContext, android.R.color.transparent));
        }
    }
}
