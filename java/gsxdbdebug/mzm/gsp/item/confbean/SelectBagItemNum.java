/*    */ package mzm.gsp.item.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SelectBagItemNum implements Marshal
/*    */ {
/*    */   public int itemid;
/*    */   public int num;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.itemid = Integer.valueOf(rootElement.attributeValue("itemid")).intValue();
/* 15 */     this.num = Integer.valueOf(rootElement.attributeValue("num")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.itemid);
/* 21 */     _os_.marshal(this.num);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.itemid = _os_.unmarshal_int();
/* 28 */     this.num = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SelectBagItemNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */