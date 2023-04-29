/*    */ package mzm.gsp.awardpool.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FlopLotteryAwardPool implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int awardPoolSumId;
/*    */   public int index;
/*    */   public int moneyType;
/*    */   public int moneyCount;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 18 */     this.awardPoolSumId = Integer.valueOf(rootElement.attributeValue("awardPoolSumId")).intValue();
/* 19 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/* 20 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/* 21 */     this.moneyCount = Integer.valueOf(rootElement.attributeValue("moneyCount")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 26 */     _os_.marshal(this.id);
/* 27 */     _os_.marshal(this.awardPoolSumId);
/* 28 */     _os_.marshal(this.index);
/* 29 */     _os_.marshal(this.moneyType);
/* 30 */     _os_.marshal(this.moneyCount);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 36 */     this.id = _os_.unmarshal_int();
/* 37 */     this.awardPoolSumId = _os_.unmarshal_int();
/* 38 */     this.index = _os_.unmarshal_int();
/* 39 */     this.moneyType = _os_.unmarshal_int();
/* 40 */     this.moneyCount = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\confbean\FlopLotteryAwardPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */