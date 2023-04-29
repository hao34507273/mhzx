/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class RoleVitalityInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/* 11 */   public Octets name = new Octets();
/*    */   
/*    */   public int level;
/*    */   
/*    */   public byte gender;
/*    */   public int occupation;
/*    */   public int fight;
/*    */   public int zoneid;
/*    */   public int vitality;
/*    */   public long time;
/*    */   
/*    */   public OctetsStream marshal(OctetsStream os)
/*    */   {
/* 24 */     os.marshal(this.roleid);
/* 25 */     os.marshal(this.name);
/* 26 */     os.marshal(this.level);
/* 27 */     os.marshal(this.gender);
/* 28 */     os.marshal(this.occupation);
/* 29 */     os.marshal(this.fight);
/* 30 */     os.marshal(this.zoneid);
/*    */     
/* 32 */     os.marshal(this.vitality);
/* 33 */     os.marshal(this.time);
/* 34 */     return os;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream os)
/*    */     throws MarshalException
/*    */   {
/* 40 */     this.roleid = os.unmarshal_long();
/* 41 */     this.name = os.unmarshal_Octets();
/* 42 */     this.level = os.unmarshal_int();
/* 43 */     this.gender = os.unmarshal_byte();
/* 44 */     this.occupation = os.unmarshal_int();
/* 45 */     this.fight = os.unmarshal_int();
/* 46 */     this.zoneid = os.unmarshal_int();
/*    */     
/* 48 */     this.vitality = os.unmarshal_int();
/* 49 */     this.time = os.unmarshal_long();
/* 50 */     return os;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\RoleVitalityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */