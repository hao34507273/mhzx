/*    */ package mzm.gsp.activity4.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FlowerParadePos implements Marshal
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */   public int index;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.x = Integer.valueOf(rootElement.attributeValue("x")).intValue();
/* 16 */     this.y = Integer.valueOf(rootElement.attributeValue("y")).intValue();
/* 17 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.x);
/* 23 */     _os_.marshal(this.y);
/* 24 */     _os_.marshal(this.index);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.x = _os_.unmarshal_int();
/* 31 */     this.y = _os_.unmarshal_int();
/* 32 */     this.index = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\FlowerParadePos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */