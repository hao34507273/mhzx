/*    */ package mzm.gsp.award.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FixItemBean implements Marshal
/*    */ {
/*    */   public int itemId;
/*    */   public int num;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.itemId = Integer.valueOf(rootElement.attributeValue("itemId")).intValue();
/* 15 */     this.num = Integer.valueOf(rootElement.attributeValue("num")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.itemId);
/* 21 */     _os_.marshal(this.num);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.itemId = _os_.unmarshal_int();
/* 28 */     this.num = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\FixItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */