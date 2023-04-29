/*    */ package mzm.gsp.activitypointexchange.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RefreshCostInfo implements Marshal
/*    */ {
/*    */   public int index;
/*    */   public int moneyType;
/*    */   public int moneyCount;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/* 16 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/* 17 */     this.moneyCount = Integer.valueOf(rootElement.attributeValue("moneyCount")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.index);
/* 23 */     _os_.marshal(this.moneyType);
/* 24 */     _os_.marshal(this.moneyCount);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.index = _os_.unmarshal_int();
/* 31 */     this.moneyType = _os_.unmarshal_int();
/* 32 */     this.moneyCount = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\confbean\RefreshCostInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */