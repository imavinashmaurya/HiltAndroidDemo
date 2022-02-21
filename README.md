# HiltAndroidDemo
Step 1
In Root build.gradel

     
      ext {
        hilt_version = '2.38.1'
      }
     
      dependencies {
        classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
      }
      
      
 Step 2
 In project build.gradel
 
 ```
 plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
    id 'kotlin-parcelize'
    id 'dagger.hilt.android.plugin'
}
```

```
dependencies {
    // Hilt
    // dagger hilt
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-android-compiler:$hilt_version"
}
```

Step 3

```
@HiltAndroidApp
class BaseApplication: Application()
```


Step 4
Create Module class

```
@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Singleton
    @Provides
    fun getIndianFood(): IndianFood {
        return IndianFood()
    }
    @Provides
    fun getChineseFood(): ChineseFood {
        return ChineseFood()
    }
}
```

Step 5
Main Usage

```
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var indianFood: IndianFood

    @Inject
    lateinit var chineseFood: ChineseFood

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btIndian.setOnClickListener {
            binding.tvStatus.text =
                "Food Details:${indianFood.foodType()},${indianFood.foodCount()}"
            indianFood.specialFood()
        }
        binding.btChinese.setOnClickListener {
            binding.tvStatus.text =
                "Food Details:${chineseFood.foodType()},${chineseFood.foodCount()}"
        }

        binding.btNext.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }
    }
}
```

Note: IF we dont define Module class then we can call it using below in desire class
```
@Inject constructor()
@Inject constructor(@ApplicationContext context: Context)
```

Eg:
```
class IndianFood @Inject constructor()
```
