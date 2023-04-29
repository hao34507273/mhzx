/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.zoo.AnimalInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SUseEmbryoItemSuccess
/*    */   extends __SUseEmbryoItemSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584871;
/*    */   public int item_cfgid;
/*    */   public int used_num;
/*    */   public AnimalInfo animal_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584871;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseEmbryoItemSuccess()
/*    */   {
/* 35 */     this.animal_info = new AnimalInfo();
/*    */   }
/*    */   
/*    */   public SUseEmbryoItemSuccess(int _item_cfgid_, int _used_num_, AnimalInfo _animal_info_) {
/* 39 */     this.item_cfgid = _item_cfgid_;
/* 40 */     this.used_num = _used_num_;
/* 41 */     this.animal_info = _animal_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.animal_info._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.item_cfgid);
/* 51 */     _os_.marshal(this.used_num);
/* 52 */     _os_.marshal(this.animal_info);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.item_cfgid = _os_.unmarshal_int();
/* 58 */     this.used_num = _os_.unmarshal_int();
/* 59 */     this.animal_info.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SUseEmbryoItemSuccess)) {
/* 69 */       SUseEmbryoItemSuccess _o_ = (SUseEmbryoItemSuccess)_o1_;
/* 70 */       if (this.item_cfgid != _o_.item_cfgid) return false;
/* 71 */       if (this.used_num != _o_.used_num) return false;
/* 72 */       if (!this.animal_info.equals(_o_.animal_info)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.item_cfgid;
/* 81 */     _h_ += this.used_num;
/* 82 */     _h_ += this.animal_info.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.item_cfgid).append(",");
/* 90 */     _sb_.append(this.used_num).append(",");
/* 91 */     _sb_.append(this.animal_info).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SUseEmbryoItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */