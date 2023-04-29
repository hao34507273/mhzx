/*    */ package mzm.gsp.map.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class Point implements Marshal
/*    */ {
/*    */   public int posX;
/*    */   public int posY;
/*    */   public int stayTime;
/*    */   public int hideType;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.posX = Integer.valueOf(rootElement.attributeValue("posX")).intValue();
/* 17 */     this.posY = Integer.valueOf(rootElement.attributeValue("posY")).intValue();
/* 18 */     this.stayTime = Integer.valueOf(rootElement.attributeValue("stayTime")).intValue();
/* 19 */     this.hideType = Integer.valueOf(rootElement.attributeValue("hideType")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.posX);
/* 25 */     _os_.marshal(this.posY);
/* 26 */     _os_.marshal(this.stayTime);
/* 27 */     _os_.marshal(this.hideType);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.posX = _os_.unmarshal_int();
/* 34 */     this.posY = _os_.unmarshal_int();
/* 35 */     this.stayTime = _os_.unmarshal_int();
/* 36 */     this.hideType = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */