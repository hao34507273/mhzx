/*    */ package mzm.gsp.ballbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SGroundItemPosition implements Marshal
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.x = Integer.valueOf(rootElement.attributeValue("x")).intValue();
/* 15 */     this.y = Integer.valueOf(rootElement.attributeValue("y")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.x);
/* 21 */     _os_.marshal(this.y);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.x = _os_.unmarshal_int();
/* 28 */     this.y = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\confbean\SGroundItemPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */