# lazy-viewholder
Implementation of ViewHolder pattern with lazy or eagle initialization. 
Can be used within ListAdapter, Activity or Fragment.

### Usage

##### Lazy initialization
Method find(id) is used to get view from ViewHolder.
Views are stored with first request.
```java

       private LazyHolder lh;
       
       ...
       
       private void updateViews() {
            View view = lh.find(R.id.view);
            TextView text = lh.find(R.id.text);
            ImageView image = lh.find(R.id.image);
            
            ...
       }
```

##### Eagle initialization
To iterate and hold all views at once.
```java
    lazyHolder.findAll();
```


### Instance creation

##### ListAdapter
```java
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LazyHolder viewHolder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(id, parent, false);

                viewHolder = new LazyViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = convertView.getTag();
            }
            
            ...
            
            return convertView;
        }
```

##### Activity
```java

       private LazyHolder lh;
        
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(id);
           
           lh = new LazyActivityViewHolder(this);
       }
```

##### Fragment
```java

       private LazyHolder lh;
   
       @Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           View view = inflater.inflate(id, container, false);
   
           lh = new LazyViewHolder(v);

           return view;
       }
```