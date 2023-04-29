/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncPetFightPosition
/*    */   extends __SSyncPetFightPosition__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590703;
/*    */   public int team;
/*    */   public HashMap<Integer, Long> position2pet;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590703;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncPetFightPosition()
/*    */   {
/* 34 */     this.position2pet = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncPetFightPosition(int _team_, HashMap<Integer, Long> _position2pet_) {
/* 38 */     this.team = _team_;
/* 39 */     this.position2pet = _position2pet_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.team);
/* 48 */     _os_.compact_uint32(this.position2pet.size());
/* 49 */     for (Map.Entry<Integer, Long> _e_ : this.position2pet.entrySet()) {
/* 50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 51 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.team = _os_.unmarshal_int();
/* 58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 60 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 62 */       long _v_ = _os_.unmarshal_long();
/* 63 */       this.position2pet.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SSyncPetFightPosition)) {
/* 74 */       SSyncPetFightPosition _o_ = (SSyncPetFightPosition)_o1_;
/* 75 */       if (this.team != _o_.team) return false;
/* 76 */       if (!this.position2pet.equals(_o_.position2pet)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.team;
/* 85 */     _h_ += this.position2pet.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.team).append(",");
/* 93 */     _sb_.append(this.position2pet).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSyncPetFightPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */