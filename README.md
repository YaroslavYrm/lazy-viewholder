# Lazy-ViewHolder
Implementation of ViewHolder pattern based on SparseArray. 
Can be used within ListAdapter, Activity or Fragment with lazy or eagle initialization.

### Usage

##### Lazy initialization
Method find(id) is used to get view from ViewHolder.
Views are stored in SparseArray with first method call.
```java

       private void updateViews(LazyHolder lh) {
            View view = lh.find(R.id.view);
            TextView text = lh.findTextView(R.id.text);
            ImageView image = lh.findImageView(R.id.image);
            GridView grid = lh.find(GridView.class, R.id.grid);
            ...
       }
```

##### Eagle initialization
To iterate and hold all views at once.
```java
    lh.findAll();
```
Except this call usage is the same as with lazy initialization.

### Instance creation

##### ListAdapter
```java
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LazyHolder lh;
            if (convertView == null) {
                convertView = layoutInflater.inflate(id, parent, false);

                lh = new LazyViewHolder(convertView);
                convertView.setTag(lh);
            } else {
                lh = (LazyHolder) convertView.getTag();
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
   
           lh = new LazyViewHolder(view);

           return view;
       }
```