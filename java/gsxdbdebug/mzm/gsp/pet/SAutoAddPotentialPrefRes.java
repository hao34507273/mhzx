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
/*    */ public class SAutoAddPotentialPrefRes
/*    */   extends __SAutoAddPotentialPrefRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590645;
/*    */   public long petid;
/*    */   public HashMap<Integer, Integer> propmap;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590645;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAutoAddPotentialPrefRes()
/*    */   {
/* 34 */     this.propmap = new HashMap();
/*    */   }
/*    */   
/*    */   public SAutoAddPotentialPrefRes(long _petid_, HashMap<Integer, Integer> _propmap_) {
/* 38 */     this.petid = _petid_;
/* 39 */     this.propmap = _propmap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.petid);
/* 48 */     _os_.compact_uint32(this.propmap.size());
/* 49 */     for (Map.Entry<Integer, Integer> _e_ : this.propmap.entrySet()) {
/* 50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 51 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.petid = _os_.unmarshal_long();
/* 58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 60 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 62 */       int _v_ = _os_.unmarshal_int();
/* 63 */       this.propmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SAutoAddPotentialPrefRes)) {
/* 74 */       SAutoAddPotentialPrefRes _o_ = (SAutoAddPotentialPrefRes)_o1_;
/* 75 */       if (this.petid != _o_.petid) return false;
/* 76 */       if (!this.propmap.equals(_o_.propmap)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.petid;
/* 85 */     _h_ += this.propmap.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.petid).append(",");
/* 93 */     _sb_.append(this.propmap).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SAutoAddPotentialPrefRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */