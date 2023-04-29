/*    */ package mzm.gsp.genius;
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
/*    */ public class SSavePlanSuccess
/*    */   extends __SSavePlanSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613890;
/*    */   public int genius_series_id;
/*    */   public HashMap<Integer, Integer> genius_skills;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613890;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSavePlanSuccess()
/*    */   {
/* 34 */     this.genius_skills = new HashMap();
/*    */   }
/*    */   
/*    */   public SSavePlanSuccess(int _genius_series_id_, HashMap<Integer, Integer> _genius_skills_) {
/* 38 */     this.genius_series_id = _genius_series_id_;
/* 39 */     this.genius_skills = _genius_skills_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.genius_series_id);
/* 48 */     _os_.compact_uint32(this.genius_skills.size());
/* 49 */     for (Map.Entry<Integer, Integer> _e_ : this.genius_skills.entrySet()) {
/* 50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 51 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.genius_series_id = _os_.unmarshal_int();
/* 58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 60 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 62 */       int _v_ = _os_.unmarshal_int();
/* 63 */       this.genius_skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SSavePlanSuccess)) {
/* 74 */       SSavePlanSuccess _o_ = (SSavePlanSuccess)_o1_;
/* 75 */       if (this.genius_series_id != _o_.genius_series_id) return false;
/* 76 */       if (!this.genius_skills.equals(_o_.genius_skills)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.genius_series_id;
/* 85 */     _h_ += this.genius_skills.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.genius_series_id).append(",");
/* 93 */     _sb_.append(this.genius_skills).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\SSavePlanSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */