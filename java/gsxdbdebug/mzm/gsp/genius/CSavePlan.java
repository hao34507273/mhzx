/*     */ package mzm.gsp.genius;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.genius.main.PCSavePlan;
/*     */ 
/*     */ public class CSavePlan
/*     */   extends __CSavePlan__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613893;
/*     */   public int genius_series_id;
/*     */   public HashMap<Integer, Integer> genius_skills;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCSavePlan(roleId, this.genius_series_id, this.genius_skills));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12613893;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CSavePlan()
/*     */   {
/*  39 */     this.genius_skills = new HashMap();
/*     */   }
/*     */   
/*     */   public CSavePlan(int _genius_series_id_, HashMap<Integer, Integer> _genius_skills_) {
/*  43 */     this.genius_series_id = _genius_series_id_;
/*  44 */     this.genius_skills = _genius_skills_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.genius_series_id);
/*  53 */     _os_.compact_uint32(this.genius_skills.size());
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : this.genius_skills.entrySet()) {
/*  55 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  56 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.genius_series_id = _os_.unmarshal_int();
/*  63 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  65 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.genius_skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CSavePlan)) {
/*  79 */       CSavePlan _o_ = (CSavePlan)_o1_;
/*  80 */       if (this.genius_series_id != _o_.genius_series_id) return false;
/*  81 */       if (!this.genius_skills.equals(_o_.genius_skills)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.genius_series_id;
/*  90 */     _h_ += this.genius_skills.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.genius_series_id).append(",");
/*  98 */     _sb_.append(this.genius_skills).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\CSavePlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */