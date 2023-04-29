/*     */ package jsonio;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class JsonStream
/*     */ {
/*   9 */   private static volatile boolean optionalKey = false;
/*     */   private final JSONObject stream;
/*     */   
/*     */   public static void enableOptionalKey() {
/*  13 */     optionalKey = true;
/*     */   }
/*     */   
/*     */   public static void disableOptionalKey()
/*     */   {
/*  18 */     optionalKey = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public JsonStream()
/*     */   {
/*  25 */     this.stream = new JSONObject();
/*     */   }
/*     */   
/*     */   public JsonStream(String data) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/*  32 */       this.stream = new JSONObject(data);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/*  36 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public JsonStream(JSONObject stream)
/*     */   {
/*  42 */     this.stream = stream;
/*     */   }
/*     */   
/*     */   public JSONObject getJSONObject()
/*     */   {
/*  47 */     return this.stream;
/*     */   }
/*     */   
/*     */   public <V> JsonStream marshal(String key, V value)
/*     */   {
/*  52 */     this.stream.put(key, value);
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public JsonStream marshal(String key, JsonStream js)
/*     */   {
/*  58 */     this.stream.put(key, js.stream);
/*  59 */     return this;
/*     */   }
/*     */   
/*     */   public JsonStream marshal(String key, JsonMarshal jm)
/*     */   {
/*  64 */     JsonStream js = jm.marshal(new JsonStream());
/*  65 */     marshal(key, js);
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public byte unmarshal_byte(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/*  73 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/*  75 */         return 0;
/*     */       }
/*     */       
/*  78 */       return (byte)this.stream.getInt(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/*  82 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean unmarshal_boolean(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/*  90 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/*  92 */         return false;
/*     */       }
/*     */       
/*  95 */       return this.stream.getBoolean(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/*  99 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public short unmarshal_short(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/* 107 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/* 109 */         return 0;
/*     */       }
/*     */       
/* 112 */       return (short)this.stream.getInt(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 116 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public char unmarshal_char(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/* 124 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/* 126 */         return '\000';
/*     */       }
/*     */       
/* 129 */       return (char)this.stream.getInt(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 133 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public int unmarshal_int(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/* 141 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/* 143 */         return 0;
/*     */       }
/*     */       
/* 146 */       return this.stream.getInt(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 150 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public long unmarshal_long(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/* 158 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/* 160 */         return 0L;
/*     */       }
/*     */       
/* 163 */       return this.stream.getLong(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 167 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public float unmarshal_float(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/* 175 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/* 177 */         return 0.0F;
/*     */       }
/*     */       
/* 180 */       return (float)this.stream.getDouble(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 184 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public double unmarshal_double(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/* 192 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/* 194 */         return 0.0D;
/*     */       }
/*     */       
/* 197 */       return this.stream.getDouble(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 201 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public String unmarshal_string(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/* 209 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/* 211 */         return "";
/*     */       }
/*     */       
/* 214 */       return this.stream.getString(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 218 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public org.json.JSONArray unmarshal_json_array(String key) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/* 226 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/* 228 */         return new org.json.JSONArray();
/*     */       }
/*     */       
/* 231 */       return this.stream.getJSONArray(key);
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 235 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(String key, JsonMarshal jm) throws JsonMarshalException
/*     */   {
/*     */     try
/*     */     {
/* 243 */       if ((optionalKey) && (this.stream.isNull(key)))
/*     */       {
/* 245 */         return this;
/*     */       }
/*     */       
/* 248 */       JSONObject jmo = this.stream.getJSONObject(key);
/* 249 */       jm.unmarshal(new JsonStream(jmo));
/* 250 */       return this;
/*     */     }
/*     */     catch (JSONException e)
/*     */     {
/* 254 */       throw new JsonMarshalException(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 261 */     return this.stream.toString();
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 266 */     enableOptionalKey();
/* 267 */     JsonStream js = new JsonStream("{\"tag1\": null, \"tag2\": 2}");
/* 268 */     System.out.println(js.getJSONObject().isNull("tag1"));
/* 269 */     System.out.println(js.getJSONObject().isNull("tag2"));
/* 270 */     System.out.println(js.unmarshal_int("tag1"));
/* 271 */     System.out.println(js.unmarshal_int("tag2"));
/* 272 */     System.out.println(js.unmarshal_int("tag3"));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\jsonio\JsonStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */