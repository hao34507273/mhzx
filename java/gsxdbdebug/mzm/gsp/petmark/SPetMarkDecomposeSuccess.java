/*    */ package mzm.gsp.petmark;
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
/*    */ public class SPetMarkDecomposeSuccess
/*    */   extends __SPetMarkDecomposeSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628481;
/*    */   public long pet_mark_id;
/*    */   public HashMap<Integer, Integer> get_score_map;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628481;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SPetMarkDecomposeSuccess()
/*    */   {
/* 34 */     this.get_score_map = new HashMap();
/*    */   }
/*    */   
/*    */   public SPetMarkDecomposeSuccess(long _pet_mark_id_, HashMap<Integer, Integer> _get_score_map_) {
/* 38 */     this.pet_mark_id = _pet_mark_id_;
/* 39 */     this.get_score_map = _get_score_map_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.pet_mark_id);
/* 48 */     _os_.compact_uint32(this.get_score_map.size());
/* 49 */     for (Map.Entry<Integer, Integer> _e_ : this.get_score_map.entrySet()) {
/* 50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 51 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.pet_mark_id = _os_.unmarshal_long();
/* 58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 60 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 62 */       int _v_ = _os_.unmarshal_int();
/* 63 */       this.get_score_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SPetMarkDecomposeSuccess)) {
/* 74 */       SPetMarkDecomposeSuccess _o_ = (SPetMarkDecomposeSuccess)_o1_;
/* 75 */       if (this.pet_mark_id != _o_.pet_mark_id) return false;
/* 76 */       if (!this.get_score_map.equals(_o_.get_score_map)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.pet_mark_id;
/* 85 */     _h_ += this.get_score_map.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.pet_mark_id).append(",");
/* 93 */     _sb_.append(this.get_score_map).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SPetMarkDecomposeSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */