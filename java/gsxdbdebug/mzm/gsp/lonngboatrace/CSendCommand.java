/*     */ package mzm.gsp.lonngboatrace;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CSendCommand extends __CSendCommand__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619276;
/*     */   public int raceid;
/*     */   public int phaseno;
/*     */   public int round;
/*     */   public int times;
/*     */   public ArrayList<Integer> commandlist;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L)
/*  21 */       return;
/*  22 */     Role.addRoleProcedure(roleId, new mzm.gsp.lonngboatrace.main.PCSendCommand(this.raceid, this.phaseno, this.round, this.times, this.commandlist, roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12619276;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSendCommand()
/*     */   {
/*  41 */     this.commandlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public CSendCommand(int _raceid_, int _phaseno_, int _round_, int _times_, ArrayList<Integer> _commandlist_) {
/*  45 */     this.raceid = _raceid_;
/*  46 */     this.phaseno = _phaseno_;
/*  47 */     this.round = _round_;
/*  48 */     this.times = _times_;
/*  49 */     this.commandlist = _commandlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.raceid);
/*  58 */     _os_.marshal(this.phaseno);
/*  59 */     _os_.marshal(this.round);
/*  60 */     _os_.marshal(this.times);
/*  61 */     _os_.compact_uint32(this.commandlist.size());
/*  62 */     for (Integer _v_ : this.commandlist) {
/*  63 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.raceid = _os_.unmarshal_int();
/*  70 */     this.phaseno = _os_.unmarshal_int();
/*  71 */     this.round = _os_.unmarshal_int();
/*  72 */     this.times = _os_.unmarshal_int();
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  75 */       int _v_ = _os_.unmarshal_int();
/*  76 */       this.commandlist.add(Integer.valueOf(_v_));
/*     */     }
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof CSendCommand)) {
/*  87 */       CSendCommand _o_ = (CSendCommand)_o1_;
/*  88 */       if (this.raceid != _o_.raceid) return false;
/*  89 */       if (this.phaseno != _o_.phaseno) return false;
/*  90 */       if (this.round != _o_.round) return false;
/*  91 */       if (this.times != _o_.times) return false;
/*  92 */       if (!this.commandlist.equals(_o_.commandlist)) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += this.raceid;
/* 101 */     _h_ += this.phaseno;
/* 102 */     _h_ += this.round;
/* 103 */     _h_ += this.times;
/* 104 */     _h_ += this.commandlist.hashCode();
/* 105 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder _sb_ = new StringBuilder();
/* 110 */     _sb_.append("(");
/* 111 */     _sb_.append(this.raceid).append(",");
/* 112 */     _sb_.append(this.phaseno).append(",");
/* 113 */     _sb_.append(this.round).append(",");
/* 114 */     _sb_.append(this.times).append(",");
/* 115 */     _sb_.append(this.commandlist).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\CSendCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */