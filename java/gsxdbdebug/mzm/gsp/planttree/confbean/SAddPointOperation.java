/*    */ package mzm.gsp.planttree.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SAddPointOperation implements Marshal
/*    */ {
/*    */   public int money_type;
/*    */   public int money_num;
/*    */   public int point;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.money_type = Integer.valueOf(rootElement.attributeValue("money_type")).intValue();
/* 16 */     this.money_num = Integer.valueOf(rootElement.attributeValue("money_num")).intValue();
/* 17 */     this.point = Integer.valueOf(rootElement.attributeValue("point")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.money_type);
/* 23 */     _os_.marshal(this.money_num);
/* 24 */     _os_.marshal(this.point);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.money_type = _os_.unmarshal_int();
/* 31 */     this.money_num = _os_.unmarshal_int();
/* 32 */     this.point = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\confbean\SAddPointOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */