/*    */ package mzm.gsp.award.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ServerLevelModify implements Marshal
/*    */ {
/*    */   public int levelMin;
/*    */   public int levelMax;
/*    */   public double roleExpMod;
/*    */   public double petExpMod;
/*    */   public double practiceMod;
/*    */   public int effectLevel;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 18 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/* 19 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/* 20 */     this.roleExpMod = Double.valueOf(rootElement.attributeValue("roleExpMod")).doubleValue();
/* 21 */     this.petExpMod = Double.valueOf(rootElement.attributeValue("petExpMod")).doubleValue();
/* 22 */     this.practiceMod = Double.valueOf(rootElement.attributeValue("practiceMod")).doubleValue();
/* 23 */     this.effectLevel = Integer.valueOf(rootElement.attributeValue("effectLevel")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 28 */     _os_.marshal(this.levelMin);
/* 29 */     _os_.marshal(this.levelMax);
/* 30 */     _os_.marshal(this.roleExpMod);
/* 31 */     _os_.marshal(this.petExpMod);
/* 32 */     _os_.marshal(this.practiceMod);
/* 33 */     _os_.marshal(this.effectLevel);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 39 */     this.levelMin = _os_.unmarshal_int();
/* 40 */     this.levelMax = _os_.unmarshal_int();
/* 41 */     this.roleExpMod = _os_.unmarshal_float();
/* 42 */     this.petExpMod = _os_.unmarshal_float();
/* 43 */     this.practiceMod = _os_.unmarshal_float();
/* 44 */     this.effectLevel = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\ServerLevelModify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */