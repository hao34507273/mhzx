/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class GangHelper extends XBean implements xbean.GangHelper
/*     */ {
/*     */   private long uid;
/*     */   private long roleid;
/*     */   private int helpertype;
/*     */   private HashMap<Integer, Integer> intmap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.uid = 0L;
/*  25 */     this.roleid = 0L;
/*  26 */     this.helpertype = 0;
/*  27 */     this.intmap.clear();
/*     */   }
/*     */   
/*     */   GangHelper(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.intmap = new HashMap();
/*     */   }
/*     */   
/*     */   public GangHelper()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GangHelper(GangHelper _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GangHelper(xbean.GangHelper _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof GangHelper)) { assign((GangHelper)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GangHelper _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.uid = _o_.uid;
/*  59 */     this.roleid = _o_.roleid;
/*  60 */     this.helpertype = _o_.helpertype;
/*  61 */     this.intmap = new HashMap();
/*  62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.intmap.entrySet()) {
/*  63 */       this.intmap.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  68 */     this.uid = _o_.uid;
/*  69 */     this.roleid = _o_.roleid;
/*  70 */     this.helpertype = _o_.helpertype;
/*  71 */     this.intmap = new HashMap();
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : _o_.intmap.entrySet()) {
/*  73 */       this.intmap.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.uid);
/*  81 */     _os_.marshal(this.roleid);
/*  82 */     _os_.marshal(this.helpertype);
/*  83 */     _os_.compact_uint32(this.intmap.size());
/*  84 */     for (Map.Entry<Integer, Integer> _e_ : this.intmap.entrySet())
/*     */     {
/*  86 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  87 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     this.uid = _os_.unmarshal_long();
/*  97 */     this.roleid = _os_.unmarshal_long();
/*  98 */     this.helpertype = _os_.unmarshal_int();
/*     */     
/* 100 */     int size = _os_.uncompact_uint32();
/* 101 */     if (size >= 12)
/*     */     {
/* 103 */       this.intmap = new HashMap(size * 2);
/*     */     }
/* 105 */     for (; size > 0; size--)
/*     */     {
/* 107 */       int _k_ = 0;
/* 108 */       _k_ = _os_.unmarshal_int();
/* 109 */       int _v_ = 0;
/* 110 */       _v_ = _os_.unmarshal_int();
/* 111 */       this.intmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     _size_ += CodedOutputStream.computeInt64Size(1, this.uid);
/* 123 */     _size_ += CodedOutputStream.computeInt64Size(2, this.roleid);
/* 124 */     _size_ += CodedOutputStream.computeInt32Size(3, this.helpertype);
/* 125 */     for (Map.Entry<Integer, Integer> _e_ : this.intmap.entrySet())
/*     */     {
/* 127 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/* 128 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 130 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       _output_.writeInt64(1, this.uid);
/* 140 */       _output_.writeInt64(2, this.roleid);
/* 141 */       _output_.writeInt32(3, this.helpertype);
/* 142 */       for (Map.Entry<Integer, Integer> _e_ : this.intmap.entrySet())
/*     */       {
/* 144 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/* 145 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       boolean done = false;
/* 162 */       while (!done)
/*     */       {
/* 164 */         int tag = _input_.readTag();
/* 165 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 169 */           done = true;
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 174 */           this.uid = _input_.readInt64();
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 179 */           this.roleid = _input_.readInt64();
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 184 */           this.helpertype = _input_.readInt32();
/* 185 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 189 */           int _k_ = 0;
/* 190 */           _k_ = _input_.readInt32();
/* 191 */           int readTag = _input_.readTag();
/* 192 */           if (32 != readTag)
/*     */           {
/* 194 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 196 */           int _v_ = 0;
/* 197 */           _v_ = _input_.readInt32();
/* 198 */           this.intmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 199 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 203 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 205 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 214 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 220 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangHelper copy()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new GangHelper(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangHelper toData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangHelper toBean()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new GangHelper(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangHelper toDataIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangHelper toBeanIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getUid()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return this.uid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getHelpertype()
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     return this.helpertype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getIntmap()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     return xdb.Logs.logMap(new LogKey(this, "intmap"), this.intmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getIntmapAsData()
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/*     */     
/* 301 */     GangHelper _o_ = this;
/* 302 */     Map<Integer, Integer> intmap = new HashMap();
/* 303 */     for (Map.Entry<Integer, Integer> _e_ : _o_.intmap.entrySet())
/* 304 */       intmap.put(_e_.getKey(), _e_.getValue());
/* 305 */     return intmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUid(long _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "uid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogLong(this, GangHelper.this.uid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             GangHelper.this.uid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.uid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 338 */         new xdb.logs.LogLong(this, GangHelper.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 342 */             GangHelper.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 346 */     });
/* 347 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHelpertype(int _v_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     xdb.Logs.logIf(new LogKey(this, "helpertype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 359 */         new xdb.logs.LogInt(this, GangHelper.this.helpertype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 363 */             GangHelper.this.helpertype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 367 */     });
/* 368 */     this.helpertype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     GangHelper _o_ = null;
/* 376 */     if ((_o1_ instanceof GangHelper)) { _o_ = (GangHelper)_o1_;
/* 377 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 378 */       return false;
/* 379 */     if (this.uid != _o_.uid) return false;
/* 380 */     if (this.roleid != _o_.roleid) return false;
/* 381 */     if (this.helpertype != _o_.helpertype) return false;
/* 382 */     if (!this.intmap.equals(_o_.intmap)) return false;
/* 383 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     int _h_ = 0;
/* 391 */     _h_ = (int)(_h_ + this.uid);
/* 392 */     _h_ = (int)(_h_ + this.roleid);
/* 393 */     _h_ += this.helpertype;
/* 394 */     _h_ += this.intmap.hashCode();
/* 395 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 401 */     _xdb_verify_unsafe_();
/* 402 */     StringBuilder _sb_ = new StringBuilder();
/* 403 */     _sb_.append("(");
/* 404 */     _sb_.append(this.uid);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.roleid);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.helpertype);
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.intmap);
/* 411 */     _sb_.append(")");
/* 412 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 418 */     ListenableBean lb = new ListenableBean();
/* 419 */     lb.add(new xdb.logs.ListenableChanged().setVarName("uid"));
/* 420 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleid"));
/* 421 */     lb.add(new xdb.logs.ListenableChanged().setVarName("helpertype"));
/* 422 */     lb.add(new xdb.logs.ListenableMap().setVarName("intmap"));
/* 423 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GangHelper {
/*     */     private Const() {}
/*     */     
/*     */     GangHelper nThis() {
/* 430 */       return GangHelper.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangHelper copy()
/*     */     {
/* 442 */       return GangHelper.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangHelper toData()
/*     */     {
/* 448 */       return GangHelper.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GangHelper toBean()
/*     */     {
/* 453 */       return GangHelper.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangHelper toDataIf()
/*     */     {
/* 459 */       return GangHelper.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GangHelper toBeanIf()
/*     */     {
/* 464 */       return GangHelper.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUid()
/*     */     {
/* 471 */       GangHelper.this._xdb_verify_unsafe_();
/* 472 */       return GangHelper.this.uid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 479 */       GangHelper.this._xdb_verify_unsafe_();
/* 480 */       return GangHelper.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHelpertype()
/*     */     {
/* 487 */       GangHelper.this._xdb_verify_unsafe_();
/* 488 */       return GangHelper.this.helpertype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getIntmap()
/*     */     {
/* 495 */       GangHelper.this._xdb_verify_unsafe_();
/* 496 */       return xdb.Consts.constMap(GangHelper.this.intmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getIntmapAsData()
/*     */     {
/* 503 */       GangHelper.this._xdb_verify_unsafe_();
/*     */       
/* 505 */       GangHelper _o_ = GangHelper.this;
/* 506 */       Map<Integer, Integer> intmap = new HashMap();
/* 507 */       for (Map.Entry<Integer, Integer> _e_ : _o_.intmap.entrySet())
/* 508 */         intmap.put(_e_.getKey(), _e_.getValue());
/* 509 */       return intmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUid(long _v_)
/*     */     {
/* 516 */       GangHelper.this._xdb_verify_unsafe_();
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 524 */       GangHelper.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHelpertype(int _v_)
/*     */     {
/* 532 */       GangHelper.this._xdb_verify_unsafe_();
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 539 */       GangHelper.this._xdb_verify_unsafe_();
/* 540 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 546 */       GangHelper.this._xdb_verify_unsafe_();
/* 547 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 553 */       return GangHelper.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 559 */       return GangHelper.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 565 */       GangHelper.this._xdb_verify_unsafe_();
/* 566 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 572 */       return GangHelper.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 578 */       return GangHelper.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 584 */       GangHelper.this._xdb_verify_unsafe_();
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 591 */       return GangHelper.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 597 */       return GangHelper.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 603 */       return GangHelper.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 609 */       return GangHelper.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 615 */       return GangHelper.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 621 */       return GangHelper.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 627 */       return GangHelper.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GangHelper
/*     */   {
/*     */     private long uid;
/*     */     
/*     */     private long roleid;
/*     */     
/*     */     private int helpertype;
/*     */     
/*     */     private HashMap<Integer, Integer> intmap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 645 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 650 */       this.intmap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.GangHelper _o1_)
/*     */     {
/* 655 */       if ((_o1_ instanceof GangHelper)) { assign((GangHelper)_o1_);
/* 656 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 657 */       } else if ((_o1_ instanceof GangHelper.Const)) assign(((GangHelper.Const)_o1_).nThis()); else {
/* 658 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GangHelper _o_) {
/* 663 */       this.uid = _o_.uid;
/* 664 */       this.roleid = _o_.roleid;
/* 665 */       this.helpertype = _o_.helpertype;
/* 666 */       this.intmap = new HashMap();
/* 667 */       for (Map.Entry<Integer, Integer> _e_ : _o_.intmap.entrySet()) {
/* 668 */         this.intmap.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 673 */       this.uid = _o_.uid;
/* 674 */       this.roleid = _o_.roleid;
/* 675 */       this.helpertype = _o_.helpertype;
/* 676 */       this.intmap = new HashMap();
/* 677 */       for (Map.Entry<Integer, Integer> _e_ : _o_.intmap.entrySet()) {
/* 678 */         this.intmap.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.marshal(this.uid);
/* 685 */       _os_.marshal(this.roleid);
/* 686 */       _os_.marshal(this.helpertype);
/* 687 */       _os_.compact_uint32(this.intmap.size());
/* 688 */       for (Map.Entry<Integer, Integer> _e_ : this.intmap.entrySet())
/*     */       {
/* 690 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 691 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 693 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 699 */       this.uid = _os_.unmarshal_long();
/* 700 */       this.roleid = _os_.unmarshal_long();
/* 701 */       this.helpertype = _os_.unmarshal_int();
/*     */       
/* 703 */       int size = _os_.uncompact_uint32();
/* 704 */       if (size >= 12)
/*     */       {
/* 706 */         this.intmap = new HashMap(size * 2);
/*     */       }
/* 708 */       for (; size > 0; size--)
/*     */       {
/* 710 */         int _k_ = 0;
/* 711 */         _k_ = _os_.unmarshal_int();
/* 712 */         int _v_ = 0;
/* 713 */         _v_ = _os_.unmarshal_int();
/* 714 */         this.intmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 717 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 723 */       int _size_ = 0;
/* 724 */       _size_ += CodedOutputStream.computeInt64Size(1, this.uid);
/* 725 */       _size_ += CodedOutputStream.computeInt64Size(2, this.roleid);
/* 726 */       _size_ += CodedOutputStream.computeInt32Size(3, this.helpertype);
/* 727 */       for (Map.Entry<Integer, Integer> _e_ : this.intmap.entrySet())
/*     */       {
/* 729 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/* 730 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 732 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 740 */         _output_.writeInt64(1, this.uid);
/* 741 */         _output_.writeInt64(2, this.roleid);
/* 742 */         _output_.writeInt32(3, this.helpertype);
/* 743 */         for (Map.Entry<Integer, Integer> _e_ : this.intmap.entrySet())
/*     */         {
/* 745 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/* 746 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 751 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 753 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 761 */         boolean done = false;
/* 762 */         while (!done)
/*     */         {
/* 764 */           int tag = _input_.readTag();
/* 765 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 769 */             done = true;
/* 770 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 774 */             this.uid = _input_.readInt64();
/* 775 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 779 */             this.roleid = _input_.readInt64();
/* 780 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 784 */             this.helpertype = _input_.readInt32();
/* 785 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 789 */             int _k_ = 0;
/* 790 */             _k_ = _input_.readInt32();
/* 791 */             int readTag = _input_.readTag();
/* 792 */             if (32 != readTag)
/*     */             {
/* 794 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 796 */             int _v_ = 0;
/* 797 */             _v_ = _input_.readInt32();
/* 798 */             this.intmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 799 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 803 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 805 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 814 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 818 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 820 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangHelper copy()
/*     */     {
/* 826 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangHelper toData()
/*     */     {
/* 832 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GangHelper toBean()
/*     */     {
/* 837 */       return new GangHelper(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangHelper toDataIf()
/*     */     {
/* 843 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GangHelper toBeanIf()
/*     */     {
/* 848 */       return new GangHelper(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 854 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 858 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 874 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 878 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUid()
/*     */     {
/* 885 */       return this.uid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 892 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHelpertype()
/*     */     {
/* 899 */       return this.helpertype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getIntmap()
/*     */     {
/* 906 */       return this.intmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getIntmapAsData()
/*     */     {
/* 913 */       return this.intmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUid(long _v_)
/*     */     {
/* 920 */       this.uid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 927 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHelpertype(int _v_)
/*     */     {
/* 934 */       this.helpertype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 940 */       if (!(_o1_ instanceof Data)) return false;
/* 941 */       Data _o_ = (Data)_o1_;
/* 942 */       if (this.uid != _o_.uid) return false;
/* 943 */       if (this.roleid != _o_.roleid) return false;
/* 944 */       if (this.helpertype != _o_.helpertype) return false;
/* 945 */       if (!this.intmap.equals(_o_.intmap)) return false;
/* 946 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 952 */       int _h_ = 0;
/* 953 */       _h_ = (int)(_h_ + this.uid);
/* 954 */       _h_ = (int)(_h_ + this.roleid);
/* 955 */       _h_ += this.helpertype;
/* 956 */       _h_ += this.intmap.hashCode();
/* 957 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 963 */       StringBuilder _sb_ = new StringBuilder();
/* 964 */       _sb_.append("(");
/* 965 */       _sb_.append(this.uid);
/* 966 */       _sb_.append(",");
/* 967 */       _sb_.append(this.roleid);
/* 968 */       _sb_.append(",");
/* 969 */       _sb_.append(this.helpertype);
/* 970 */       _sb_.append(",");
/* 971 */       _sb_.append(this.intmap);
/* 972 */       _sb_.append(")");
/* 973 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */