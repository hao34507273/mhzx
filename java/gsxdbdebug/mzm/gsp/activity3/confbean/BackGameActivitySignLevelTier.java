/*    */ package mzm.gsp.activity3.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class BackGameActivitySignLevelTier implements Marshal
/*    */ {
/*    */   public int levelMin;
/*    */   public int levelMax;
/*    */   public int signAwardCfgTypeId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/* 16 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/* 17 */     this.signAwardCfgTypeId = Integer.valueOf(rootElement.attributeValue("signAwardCfgTypeId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.levelMin);
/* 23 */     _os_.marshal(this.levelMax);
/* 24 */     _os_.marshal(this.signAwardCfgTypeId);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.levelMin = _os_.unmarshal_int();
/* 31 */     this.levelMax = _os_.unmarshal_int();
/* 32 */     this.signAwardCfgTypeId = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\BackGameActivitySignLevelTier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */