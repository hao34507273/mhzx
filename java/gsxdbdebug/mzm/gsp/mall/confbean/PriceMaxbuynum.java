/*    */ package mzm.gsp.mall.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class PriceMaxbuynum implements Marshal
/*    */ {
/*    */   public int price;
/*    */   public int maxbuynum;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.price = Integer.valueOf(rootElement.attributeValue("price")).intValue();
/* 15 */     this.maxbuynum = Integer.valueOf(rootElement.attributeValue("maxbuynum")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.price);
/* 21 */     _os_.marshal(this.maxbuynum);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.price = _os_.unmarshal_int();
/* 28 */     this.maxbuynum = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\confbean\PriceMaxbuynum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */