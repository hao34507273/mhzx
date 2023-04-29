/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class WingCheckData implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int cfgid;
/*    */   public int colorid;
/*    */   public ArrayList<Integer> proids;
/*    */   public ArrayList<Integer> skills;
/*    */   
/*    */   public WingCheckData()
/*    */   {
/* 15 */     this.proids = new ArrayList();
/* 16 */     this.skills = new ArrayList();
/*    */   }
/*    */   
/*    */   public WingCheckData(int _cfgid_, int _colorid_, ArrayList<Integer> _proids_, ArrayList<Integer> _skills_) {
/* 20 */     this.cfgid = _cfgid_;
/* 21 */     this.colorid = _colorid_;
/* 22 */     this.proids = _proids_;
/* 23 */     this.skills = _skills_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.cfgid);
/* 32 */     _os_.marshal(this.colorid);
/* 33 */     _os_.compact_uint32(this.proids.size());
/* 34 */     for (Integer _v_ : this.proids) {
/* 35 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 37 */     _os_.compact_uint32(this.skills.size());
/* 38 */     for (Integer _v_ : this.skills) {
/* 39 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 45 */     this.cfgid = _os_.unmarshal_int();
/* 46 */     this.colorid = _os_.unmarshal_int();
/* 47 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 49 */       int _v_ = _os_.unmarshal_int();
/* 50 */       this.proids.add(Integer.valueOf(_v_));
/*    */     }
/* 52 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 54 */       int _v_ = _os_.unmarshal_int();
/* 55 */       this.skills.add(Integer.valueOf(_v_));
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof WingCheckData)) {
/* 63 */       WingCheckData _o_ = (WingCheckData)_o1_;
/* 64 */       if (this.cfgid != _o_.cfgid) return false;
/* 65 */       if (this.colorid != _o_.colorid) return false;
/* 66 */       if (!this.proids.equals(_o_.proids)) return false;
/* 67 */       if (!this.skills.equals(_o_.skills)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.cfgid;
/* 76 */     _h_ += this.colorid;
/* 77 */     _h_ += this.proids.hashCode();
/* 78 */     _h_ += this.skills.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.cfgid).append(",");
/* 86 */     _sb_.append(this.colorid).append(",");
/* 87 */     _sb_.append(this.proids).append(",");
/* 88 */     _sb_.append(this.skills).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\WingCheckData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */