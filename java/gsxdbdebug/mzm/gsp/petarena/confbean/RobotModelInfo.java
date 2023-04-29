/*    */ package mzm.gsp.petarena.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RobotModelInfo implements Marshal
/*    */ {
/*    */   public int weight;
/*    */   public int monsterModelCfgid;
/*    */   public int colorScheme;
/*    */   public int modelFacadeCfgid;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/* 17 */     this.monsterModelCfgid = Integer.valueOf(rootElement.attributeValue("monsterModelCfgid")).intValue();
/* 18 */     this.colorScheme = Integer.valueOf(rootElement.attributeValue("colorScheme")).intValue();
/* 19 */     this.modelFacadeCfgid = Integer.valueOf(rootElement.attributeValue("modelFacadeCfgid")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.weight);
/* 25 */     _os_.marshal(this.monsterModelCfgid);
/* 26 */     _os_.marshal(this.colorScheme);
/* 27 */     _os_.marshal(this.modelFacadeCfgid);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.weight = _os_.unmarshal_int();
/* 34 */     this.monsterModelCfgid = _os_.unmarshal_int();
/* 35 */     this.colorScheme = _os_.unmarshal_int();
/* 36 */     this.modelFacadeCfgid = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\confbean\RobotModelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */