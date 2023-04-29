/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class PetFightTeamInfo implements Marshal
/*    */ {
/*    */   public HashMap<Integer, Long> position2pet;
/*    */   public int formation_id;
/*    */   
/*    */   public PetFightTeamInfo()
/*    */   {
/* 15 */     this.position2pet = new HashMap();
/*    */   }
/*    */   
/*    */   public PetFightTeamInfo(HashMap<Integer, Long> _position2pet_, int _formation_id_) {
/* 19 */     this.position2pet = _position2pet_;
/* 20 */     this.formation_id = _formation_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.compact_uint32(this.position2pet.size());
/* 29 */     for (Map.Entry<Integer, Long> _e_ : this.position2pet.entrySet()) {
/* 30 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 31 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 33 */     _os_.marshal(this.formation_id);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 40 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 42 */       long _v_ = _os_.unmarshal_long();
/* 43 */       this.position2pet.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 45 */     this.formation_id = _os_.unmarshal_int();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof PetFightTeamInfo)) {
/* 52 */       PetFightTeamInfo _o_ = (PetFightTeamInfo)_o1_;
/* 53 */       if (!this.position2pet.equals(_o_.position2pet)) return false;
/* 54 */       if (this.formation_id != _o_.formation_id) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += this.position2pet.hashCode();
/* 63 */     _h_ += this.formation_id;
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.position2pet).append(",");
/* 71 */     _sb_.append(this.formation_id).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\PetFightTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */