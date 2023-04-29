/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PPetFightSetPosition;
/*    */ 
/*    */ public class CPetFightSetPositionReq
/*    */   extends __CPetFightSetPositionReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590695;
/*    */   public int team;
/*    */   public HashMap<Integer, Long> position2pet;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PPetFightSetPosition(roleId, this.team, this.position2pet));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12590695;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CPetFightSetPositionReq()
/*    */   {
/* 35 */     this.position2pet = new HashMap();
/*    */   }
/*    */   
/*    */   public CPetFightSetPositionReq(int _team_, HashMap<Integer, Long> _position2pet_) {
/* 39 */     this.team = _team_;
/* 40 */     this.position2pet = _position2pet_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.team);
/* 49 */     _os_.compact_uint32(this.position2pet.size());
/* 50 */     for (Map.Entry<Integer, Long> _e_ : this.position2pet.entrySet()) {
/* 51 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 52 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.team = _os_.unmarshal_int();
/* 59 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 61 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 63 */       long _v_ = _os_.unmarshal_long();
/* 64 */       this.position2pet.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CPetFightSetPositionReq)) {
/* 75 */       CPetFightSetPositionReq _o_ = (CPetFightSetPositionReq)_o1_;
/* 76 */       if (this.team != _o_.team) return false;
/* 77 */       if (!this.position2pet.equals(_o_.position2pet)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.team;
/* 86 */     _h_ += this.position2pet.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.team).append(",");
/* 94 */     _sb_.append(this.position2pet).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CPetFightSetPositionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */