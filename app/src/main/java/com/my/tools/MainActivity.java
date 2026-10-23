    public static class WebAppInterface {
        private Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void openPythonTool(String toolName) {
            Toast.makeText(mContext, "جاري تشغيل الأداة عبر Pydroid 3...", Toast.LENGTH_SHORT).show();
            try {
                // استهداف تطبيق Pydroid 3 بالاسم الحقيقي وبشكل إجباري ومباشر لمنع ظهور قائمة الاختيار
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setClassName("ru.iiec.pydroid3", "ru.iiec.pydroid3.MainActivity");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            } catch (Exception e) {
                try {
                    Intent fallbackIntent = mContext.getPackageManager().getLaunchIntentForPackage("ru.iiec.pydroid3");
                    if (fallbackIntent != null) {
                        fallbackIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(fallbackIntent);
                    } else {
                        Toast.makeText(mContext, "تطبيق Pydroid 3 غير مثبت، يرجى تثبيته", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(mContext, "عذراً، يرجى فتح البايثون يدوياً", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
