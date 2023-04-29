/*    */ package mzm.gsp.yuanbao.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ZengSong implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int Rmb;
/*    */   public int Song;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 13 */     this.Rmb = Integer.valueOf(rootElement.attributeValue("Rmb")).intValue();
/* 14 */     this.Song = Integer.valueOf(rootElement.attributeValue("Song")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream octetsStream)
/*    */   {
/* 19 */     octetsStream.marshal(this.Rmb);
/* 20 */     octetsStream.marshal(this.Song);
/* 21 */     return octetsStream;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream octetsStream) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 26 */     this.Rmb = octetsStream.unmarshal_int();
/* 27 */     this.Song = octetsStream.unmarshal_int();
/* 28 */     return octetsStream;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yuanbao\confbean\ZengSong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */