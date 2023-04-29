/*    */ package mzm.gsp.shanggong.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SGongPinInfo implements Marshal
/*    */ {
/*    */   public int point;
/*    */   public int money_type;
/*    */   public int money_num;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.point = Integer.valueOf(rootElement.attributeValue("point")).intValue();
/* 16 */     this.money_type = Integer.valueOf(rootElement.attributeValue("money_type")).intValue();
/* 17 */     this.money_num = Integer.valueOf(rootElement.attributeValue("money_num")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.point);
/* 23 */     _os_.marshal(this.money_type);
/* 24 */     _os_.marshal(this.money_num);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.point = _os_.unmarshal_int();
/* 31 */     this.money_type = _os_.unmarshal_int();
/* 32 */     this.money_num = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanggong\confbean\SGongPinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */