/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xbean.PetOutFightBean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class Role2PetBean extends XBean implements xbean.Role2PetBean
/*     */ {
/*     */   private HashMap<Long, PetOutFightBean> beanmap;
/*     */   private LogicProcedure action;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.beanmap.clear();
/*  21 */     this.action = null;
/*     */   }
/*     */   
/*     */   Role2PetBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.beanmap = new HashMap();
/*  28 */     this.action = null;
/*     */   }
/*     */   
/*     */   public Role2PetBean()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Role2PetBean(Role2PetBean _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Role2PetBean(xbean.Role2PetBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  50 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  56 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  62 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2PetBean copy()
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     return new Role2PetBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2PetBean toData()
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2PetBean toBean()
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*  94 */     return new Role2PetBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2PetBean toDataIf()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2PetBean toBeanIf()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, PetOutFightBean> getBeanmap()
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/* 122 */     return xdb.Logs.logMap(new LogKey(this, "beanmap"), this.beanmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public LogicProcedure getAction()
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/* 130 */     return this.action;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAction(LogicProcedure _v_)
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     xdb.Logs.logIf(new LogKey(this, "action")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 142 */         new xdb.logs.LogObject(this, Role2PetBean.this.action)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 146 */             Role2PetBean.this.action = ((LogicProcedure)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 150 */     });
/* 151 */     this.action = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     Role2PetBean _o_ = null;
/* 159 */     if ((_o1_ instanceof Role2PetBean)) { _o_ = (Role2PetBean)_o1_;
/* 160 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 161 */       return false;
/* 162 */     if (!this.beanmap.equals(_o_.beanmap)) return false;
/* 163 */     if (((null == this.action) && (null != _o_.action)) || ((null != this.action) && (null == _o_.action)) || ((null != this.action) && (null != _o_.action) && (!this.action.equals(_o_.action)))) return false;
/* 164 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     int _h_ = 0;
/* 172 */     _h_ += this.beanmap.hashCode();
/* 173 */     _h_ += (this.action == null ? 0 : this.action.hashCode());
/* 174 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/* 181 */     StringBuilder _sb_ = new StringBuilder();
/* 182 */     _sb_.append("(");
/* 183 */     _sb_.append(this.beanmap);
/* 184 */     _sb_.append(",");
/* 185 */     _sb_.append(this.action);
/* 186 */     _sb_.append(")");
/* 187 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 193 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 194 */     lb.add(new xdb.logs.ListenableMap().setVarName("beanmap"));
/* 195 */     lb.add(new xdb.logs.ListenableChanged().setVarName("action"));
/* 196 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Role2PetBean {
/*     */     private Const() {}
/*     */     
/*     */     Role2PetBean nThis() {
/* 203 */       return Role2PetBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 209 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetBean copy()
/*     */     {
/* 215 */       return Role2PetBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetBean toData()
/*     */     {
/* 221 */       return Role2PetBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Role2PetBean toBean()
/*     */     {
/* 226 */       return Role2PetBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetBean toDataIf()
/*     */     {
/* 232 */       return Role2PetBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Role2PetBean toBeanIf()
/*     */     {
/* 237 */       return Role2PetBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, PetOutFightBean> getBeanmap()
/*     */     {
/* 244 */       Role2PetBean.this._xdb_verify_unsafe_();
/* 245 */       return xdb.Consts.constMap(Role2PetBean.this.beanmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public LogicProcedure getAction()
/*     */     {
/* 252 */       Role2PetBean.this._xdb_verify_unsafe_();
/* 253 */       return Role2PetBean.this.action;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAction(LogicProcedure _v_)
/*     */     {
/* 260 */       Role2PetBean.this._xdb_verify_unsafe_();
/* 261 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 267 */       Role2PetBean.this._xdb_verify_unsafe_();
/* 268 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 274 */       Role2PetBean.this._xdb_verify_unsafe_();
/* 275 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 281 */       return Role2PetBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 287 */       return Role2PetBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 293 */       Role2PetBean.this._xdb_verify_unsafe_();
/* 294 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 300 */       return Role2PetBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 306 */       return Role2PetBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 312 */       Role2PetBean.this._xdb_verify_unsafe_();
/* 313 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 319 */       return Role2PetBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 325 */       return Role2PetBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 331 */       return Role2PetBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 337 */       return Role2PetBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 343 */       return Role2PetBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 349 */       return Role2PetBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 355 */       return Role2PetBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Role2PetBean
/*     */   {
/*     */     private HashMap<Long, PetOutFightBean> beanmap;
/*     */     
/*     */     private LogicProcedure action;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 374 */       this.beanmap = new HashMap();
/* 375 */       this.action = null;
/*     */     }
/*     */     
/*     */     Data(xbean.Role2PetBean _o1_)
/*     */     {
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 386 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 392 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 398 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 404 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 410 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetBean copy()
/*     */     {
/* 416 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetBean toData()
/*     */     {
/* 422 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Role2PetBean toBean()
/*     */     {
/* 427 */       return new Role2PetBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PetBean toDataIf()
/*     */     {
/* 433 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Role2PetBean toBeanIf()
/*     */     {
/* 438 */       return new Role2PetBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 448 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 452 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 456 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 460 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 464 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 468 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, PetOutFightBean> getBeanmap()
/*     */     {
/* 475 */       return this.beanmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public LogicProcedure getAction()
/*     */     {
/* 482 */       return this.action;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAction(LogicProcedure _v_)
/*     */     {
/* 489 */       this.action = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 495 */       if (!(_o1_ instanceof Data)) return false;
/* 496 */       Data _o_ = (Data)_o1_;
/* 497 */       if (!this.beanmap.equals(_o_.beanmap)) return false;
/* 498 */       if (((null == this.action) && (null != _o_.action)) || ((null != this.action) && (null == _o_.action)) || ((null != this.action) && (null != _o_.action) && (!this.action.equals(_o_.action)))) return false;
/* 499 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 505 */       int _h_ = 0;
/* 506 */       _h_ += this.beanmap.hashCode();
/* 507 */       _h_ += (this.action == null ? 0 : this.action.hashCode());
/* 508 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 514 */       StringBuilder _sb_ = new StringBuilder();
/* 515 */       _sb_.append("(");
/* 516 */       _sb_.append(this.beanmap);
/* 517 */       _sb_.append(",");
/* 518 */       _sb_.append(this.action);
/* 519 */       _sb_.append(")");
/* 520 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2PetBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */