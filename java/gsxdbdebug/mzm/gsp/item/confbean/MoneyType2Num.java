/*    */ package mzm.gsp.item.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class MoneyType2Num implements Marshal
/*    */ {
/*    */   public int moneyType;
/*    */   public int needNum;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/* 15 */     this.needNum = Integer.valueOf(rootElement.attributeValue("needNum")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.moneyType);
/* 21 */     _os_.marshal(this.needNum);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.moneyType = _os_.unmarshal_int();
/* 28 */     this.needNum = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\MoneyType2Num.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */