/*     */ package mzm.gsp.addiction.pro;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import jsonio.JsonMarshal;
/*     */ import jsonio.JsonMarshalException;
/*     */ import jsonio.JsonStream;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class GameConfInfoRsp
/*     */   implements JsonMarshal
/*     */ {
/*     */   public int game_type;
/*     */   public int one_game_standard;
/*     */   public int accumulate_standard;
/*  18 */   public List<Integer> child_once_game_rest_time_list = new ArrayList();
/*     */   
/*     */   public int child_once_game_force_exit_time;
/*     */   public int child_once_game_force_rest_time;
/*  22 */   public List<Integer> adult_once_game_rest_time_list = new ArrayList();
/*     */   
/*     */   public int adult_once_game_force_exit_time;
/*     */   public int adult_once_game_force_rest_time;
/*     */   
/*     */   public JsonStream marshal(JsonStream js)
/*     */   {
/*  29 */     js.marshal("game_type", Integer.valueOf(this.game_type));
/*  30 */     js.marshal("one_game_standard", Integer.valueOf(this.one_game_standard));
/*  31 */     js.marshal("accumulate_standard", Integer.valueOf(this.accumulate_standard));
/*     */     
/*     */ 
/*  34 */     JSONArray ja = new JSONArray();
/*  35 */     for (Iterator i$ = this.child_once_game_rest_time_list.iterator(); i$.hasNext();) { int i = ((Integer)i$.next()).intValue();
/*     */       
/*  37 */       ja.put(i);
/*     */     }
/*  39 */     js.marshal("child_once_game_rest_time_list", ja);
/*     */     
/*  41 */     js.marshal("child_once_game_force_exit_time", Integer.valueOf(this.child_once_game_force_exit_time));
/*  42 */     js.marshal("child_once_game_force_rest_time", Integer.valueOf(this.child_once_game_force_rest_time));
/*     */     
/*     */ 
/*  45 */     JSONArray ja = new JSONArray();
/*  46 */     for (Iterator i$ = this.adult_once_game_rest_time_list.iterator(); i$.hasNext();) { int i = ((Integer)i$.next()).intValue();
/*     */       
/*  48 */       ja.put(i);
/*     */     }
/*  50 */     js.marshal("adult_once_game_rest_time_list", ja);
/*     */     
/*  52 */     js.marshal("adult_once_game_force_exit_time", Integer.valueOf(this.adult_once_game_force_exit_time));
/*  53 */     js.marshal("adult_once_game_force_rest_time", Integer.valueOf(this.adult_once_game_force_rest_time));
/*     */     
/*  55 */     return js;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream js)
/*     */     throws JsonMarshalException
/*     */   {
/*  61 */     this.game_type = js.unmarshal_int("game_type");
/*  62 */     this.one_game_standard = js.unmarshal_int("one_game_standard");
/*  63 */     this.accumulate_standard = js.unmarshal_int("accumulate_standard");
/*     */     
/*     */ 
/*  66 */     JSONObject jsonObject = js.getJSONObject();
/*  67 */     if (jsonObject.has("child_once_game_rest_time_list"))
/*     */     {
/*  69 */       JSONArray ja = js.unmarshal_json_array("child_once_game_rest_time_list");
/*  70 */       int jal = ja.length();
/*  71 */       for (int i = 0; i < jal; i++)
/*     */       {
/*  73 */         this.child_once_game_rest_time_list.add(Integer.valueOf(ja.getInt(i)));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  78 */       this.child_once_game_rest_time_list.add(Integer.valueOf(5400));
/*     */     }
/*     */     
/*  81 */     if (jsonObject.has("child_once_game_force_exit_time"))
/*     */     {
/*  83 */       this.child_once_game_force_exit_time = js.unmarshal_int("child_once_game_force_exit_time");
/*     */     }
/*     */     else
/*     */     {
/*  87 */       this.child_once_game_force_exit_time = 7200;
/*     */     }
/*     */     
/*  90 */     if (jsonObject.has("child_once_game_force_rest_time"))
/*     */     {
/*  92 */       this.child_once_game_force_rest_time = js.unmarshal_int("child_once_game_force_rest_time");
/*     */     }
/*     */     else
/*     */     {
/*  96 */       this.child_once_game_force_rest_time = 1800;
/*     */     }
/*     */     
/*  99 */     if (jsonObject.has("adult_once_game_rest_time_list"))
/*     */     {
/* 101 */       JSONArray ja = js.unmarshal_json_array("adult_once_game_rest_time_list");
/* 102 */       int jal = ja.length();
/* 103 */       for (int i = 0; i < jal; i++)
/*     */       {
/* 105 */         this.adult_once_game_rest_time_list.add(Integer.valueOf(ja.getInt(i)));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 110 */       this.adult_once_game_rest_time_list.add(Integer.valueOf(30600));
/*     */     }
/*     */     
/* 113 */     if (jsonObject.has("adult_once_game_force_exit_time"))
/*     */     {
/* 115 */       this.adult_once_game_force_exit_time = js.unmarshal_int("adult_once_game_force_exit_time");
/*     */     }
/*     */     else
/*     */     {
/* 119 */       this.adult_once_game_force_exit_time = 32400;
/*     */     }
/*     */     
/* 122 */     if (jsonObject.has("adult_once_game_force_rest_time"))
/*     */     {
/* 124 */       this.adult_once_game_force_rest_time = js.unmarshal_int("adult_once_game_force_rest_time");
/*     */     }
/*     */     else
/*     */     {
/* 128 */       this.adult_once_game_force_rest_time = 900;
/*     */     }
/*     */     
/* 131 */     return js;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\GameConfInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */