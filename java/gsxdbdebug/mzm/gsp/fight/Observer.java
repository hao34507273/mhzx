/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ 
/*    */ public class Observer implements Marshal
/*    */ {
/*    */   public static final int TYPE_ACTIVE = 0;
/*    */   public static final int TYPE_PASIVE = 1;
/*    */   public long observerid;
/*    */   public int level;
/*    */   public String name;
/*    */   public int gender;
/*    */   public int occupation;
/*    */   public ModelInfo model;
/*    */   
/*    */   public Observer()
/*    */   {
/* 20 */     this.name = "";
/* 21 */     this.model = new ModelInfo();
/*    */   }
/*    */   
/*    */   public Observer(long _observerid_, int _level_, String _name_, int _gender_, int _occupation_, ModelInfo _model_) {
/* 25 */     this.observerid = _observerid_;
/* 26 */     this.level = _level_;
/* 27 */     this.name = _name_;
/* 28 */     this.gender = _gender_;
/* 29 */     this.occupation = _occupation_;
/* 30 */     this.model = _model_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     if (!this.model._validator_()) return false;
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.observerid);
/* 40 */     _os_.marshal(this.level);
/* 41 */     _os_.marshal(this.name, "UTF-16LE");
/* 42 */     _os_.marshal(this.gender);
/* 43 */     _os_.marshal(this.occupation);
/* 44 */     _os_.marshal(this.model);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 49 */     this.observerid = _os_.unmarshal_long();
/* 50 */     this.level = _os_.unmarshal_int();
/* 51 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 52 */     this.gender = _os_.unmarshal_int();
/* 53 */     this.occupation = _os_.unmarshal_int();
/* 54 */     this.model.unmarshal(_os_);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof Observer)) {
/* 61 */       Observer _o_ = (Observer)_o1_;
/* 62 */       if (this.observerid != _o_.observerid) return false;
/* 63 */       if (this.level != _o_.level) return false;
/* 64 */       if (!this.name.equals(_o_.name)) return false;
/* 65 */       if (this.gender != _o_.gender) return false;
/* 66 */       if (this.occupation != _o_.occupation) return false;
/* 67 */       if (!this.model.equals(_o_.model)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.observerid;
/* 76 */     _h_ += this.level;
/* 77 */     _h_ += this.name.hashCode();
/* 78 */     _h_ += this.gender;
/* 79 */     _h_ += this.occupation;
/* 80 */     _h_ += this.model.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.observerid).append(",");
/* 88 */     _sb_.append(this.level).append(",");
/* 89 */     _sb_.append("T").append(this.name.length()).append(",");
/* 90 */     _sb_.append(this.gender).append(",");
/* 91 */     _sb_.append(this.occupation).append(",");
/* 92 */     _sb_.append(this.model).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\Observer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */