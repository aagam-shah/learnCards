package star.learncards;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ScreenSlidePageFragment extends Fragment  {
	
	public static String[] array={"Lion","Tiger","Elephant","Goat","Wolf","Deer","Monkey","Giraffe","Buffalo"
			,"Fox","Camel","Cow","Dog","Cat","Donkey","Kangaroo","Bear","Panda"};
	
	public static String[] fruits={"Apple","Grapes","Kiwi","Lemon","Mosambi","Orange","Pear","Pineapple","Strawberry"
		,"Apricot"};
	
	public static int[] fruits_img={R.drawable.apple,R.drawable.grapes,R.drawable.kiwi,R.drawable.lemon,R.drawable.mosambi,
		R.drawable.orange,R.drawable.pear,R.drawable.pine,R.drawable.strawberry,R.drawable.unkk};
	private TextView name;
	private ImageView image,sound;
	//private MediaPlayer player;
	private TextToSpeech tts;
	private int mPageNumber=0;
    public static int i=0;
	
	 /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    
    @Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		mPageNumber=getArguments().getInt(ARG_PAGE);
		
		
	}

    public static Fragment create(int pos){
    	ScreenSlidePageFragment sspf = new ScreenSlidePageFragment();
    	Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pos);
        Log.e("position passed", ""+pos);
        sspf.setArguments(args);
        return sspf;
    	
    }
	/**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    
    
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        name = (TextView)rootView.findViewById(R.id.textView1);
        image=(ImageView)rootView.findViewById(R.id.image);
        //name.setCameraDistance(14);
        sound=(ImageView)rootView.findViewById(R.id.sound);
        name.setText(""+fruits[mPageNumber]);
       // image.setImageDrawable(R.drawable.ic_launcher);
        image.setImageResource(fruits_img[mPageNumber]);
        tts = new TextToSpeech(getActivity(),new OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				
			}
		});
        setClickListeners();
        
        return rootView;
    }
	
	public void setClickListeners(){
		image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e("na", ""+(mPageNumber-1));
				//if(!tts.isSpeaking())
				tts.speak(""+fruits[mPageNumber], TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		
						
	}

	
}
