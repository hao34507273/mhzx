/*    */ package idip.core;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonStream;
/*    */ import org.json.JSONException;
/*    */ 
/*    */ 
/*    */ public abstract class IDIPPacket<IDIPBody extends JsonMarshal>
/*    */   implements JsonMarshal
/*    */ {
/*    */   public final IdipHeader head;
/*    */   public final IDIPBody body;
/*    */   
/*    */   public IDIPPacket(IdipHeader header, IDIPBody body)
/*    */   {
/* 16 */     this.head = header;
/* 17 */     this.body = body;
/*    */   }
/*    */   
/*    */ 
/*    */   public abstract int getPacketID();
/*    */   
/*    */   public JsonStream marshal(JsonStream js)
/*    */   {
/* 25 */     js.marshal("head", this.head);
/* 26 */     js.marshal("body", this.body);
/* 27 */     return js;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream js)
/*    */     throws JSONException
/*    */   {
/* 33 */     js.unmarshal("head", this.head);
/* 34 */     js.unmarshal("body", this.body);
/* 35 */     return js;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 41 */     JsonStream js = new JsonStream();
/* 42 */     marshal(js);
/* 43 */     return js.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\core\IDIPPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */