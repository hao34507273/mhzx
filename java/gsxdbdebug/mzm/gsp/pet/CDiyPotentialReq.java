/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PDiyPotentialPointReq;
/*    */ 
/*    */ public class CDiyPotentialReq
/*    */   extends __CDiyPotentialReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590620;
/*    */   public long petid;
/*    */   public HashMap<Integer, Integer> propmap;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PDiyPotentialPointReq(roleId, this.petid, this.propmap));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12590620;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CDiyPotentialReq()
/*    */   {
/* 38 */     this.propmap = new HashMap();
/*    */   }
/*    */   
/*    */   public CDiyPotentialReq(long _petid_, HashMap<Integer, Integer> _propmap_) {
/* 42 */     this.petid = _petid_;
/* 43 */     this.propmap = _propmap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.petid);
/* 52 */     _os_.compact_uint32(this.propmap.size());
/* 53 */     for (Map.Entry<Integer, Integer> _e_ : this.propmap.entrySet()) {
/* 54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 55 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.petid = _os_.unmarshal_long();
/* 62 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 64 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 66 */       int _v_ = _os_.unmarshal_int();
/* 67 */       this.propmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 69 */     if (!_validator_()) {
/* 70 */       throw new VerifyError("validator failed");
/*    */     }
/* 72 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 76 */     if (_o1_ == this) return true;
/* 77 */     if ((_o1_ instanceof CDiyPotentialReq)) {
/* 78 */       CDiyPotentialReq _o_ = (CDiyPotentialReq)_o1_;
/* 79 */       if (this.petid != _o_.petid) return false;
/* 80 */       if (!this.propmap.equals(_o_.propmap)) return false;
/* 81 */       return true;
/*    */     }
/* 83 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 87 */     int _h_ = 0;
/* 88 */     _h_ += (int)this.petid;
/* 89 */     _h_ += this.propmap.hashCode();
/* 90 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 94 */     StringBuilder _sb_ = new StringBuilder();
/* 95 */     _sb_.append("(");
/* 96 */     _sb_.append(this.petid).append(",");
/* 97 */     _sb_.append(this.propmap).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CDiyPotentialReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */