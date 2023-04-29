/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.children.main.PCAutoAddPotentialPrefReq;
/*    */ 
/*    */ 
/*    */ public class CAutoAddPotentialPrefReq
/*    */   extends __CAutoAddPotentialPrefReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609364;
/*    */   public long childrenid;
/*    */   public HashMap<Integer, Integer> propmap;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCAutoAddPotentialPrefReq(roleid, this.childrenid, this.propmap));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12609364;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAutoAddPotentialPrefReq()
/*    */   {
/* 36 */     this.propmap = new HashMap();
/*    */   }
/*    */   
/*    */   public CAutoAddPotentialPrefReq(long _childrenid_, HashMap<Integer, Integer> _propmap_) {
/* 40 */     this.childrenid = _childrenid_;
/* 41 */     this.propmap = _propmap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.childrenid);
/* 50 */     _os_.compact_uint32(this.propmap.size());
/* 51 */     for (Map.Entry<Integer, Integer> _e_ : this.propmap.entrySet()) {
/* 52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 53 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.childrenid = _os_.unmarshal_long();
/* 60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 62 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 64 */       int _v_ = _os_.unmarshal_int();
/* 65 */       this.propmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 67 */     if (!_validator_()) {
/* 68 */       throw new VerifyError("validator failed");
/*    */     }
/* 70 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 74 */     if (_o1_ == this) return true;
/* 75 */     if ((_o1_ instanceof CAutoAddPotentialPrefReq)) {
/* 76 */       CAutoAddPotentialPrefReq _o_ = (CAutoAddPotentialPrefReq)_o1_;
/* 77 */       if (this.childrenid != _o_.childrenid) return false;
/* 78 */       if (!this.propmap.equals(_o_.propmap)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += (int)this.childrenid;
/* 87 */     _h_ += this.propmap.hashCode();
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.childrenid).append(",");
/* 95 */     _sb_.append(this.propmap).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CAutoAddPotentialPrefReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */