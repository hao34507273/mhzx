/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ 
/*      */ public final class RoleWorshipInfo extends XBean implements xbean.RoleWorshipInfo
/*      */ {
/*      */   private int worshipid;
/*      */   private HashMap<Long, Integer> lastcycledata;
/*      */   private HashMap<Long, Integer> thiscycledata;
/*      */   private long curfactionid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.worshipid = 0;
/*   25 */     this.lastcycledata.clear();
/*   26 */     this.thiscycledata.clear();
/*   27 */     this.curfactionid = 0L;
/*      */   }
/*      */   
/*      */   RoleWorshipInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.lastcycledata = new HashMap();
/*   34 */     this.thiscycledata = new HashMap();
/*      */   }
/*      */   
/*      */   public RoleWorshipInfo()
/*      */   {
/*   39 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleWorshipInfo(RoleWorshipInfo _o_)
/*      */   {
/*   44 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleWorshipInfo(xbean.RoleWorshipInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   49 */     super(_xp_, _vn_);
/*   50 */     if ((_o1_ instanceof RoleWorshipInfo)) { assign((RoleWorshipInfo)_o1_);
/*   51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   53 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleWorshipInfo _o_) {
/*   58 */     _o_._xdb_verify_unsafe_();
/*   59 */     this.worshipid = _o_.worshipid;
/*   60 */     this.lastcycledata = new HashMap();
/*   61 */     for (Map.Entry<Long, Integer> _e_ : _o_.lastcycledata.entrySet())
/*   62 */       this.lastcycledata.put(_e_.getKey(), _e_.getValue());
/*   63 */     this.thiscycledata = new HashMap();
/*   64 */     for (Map.Entry<Long, Integer> _e_ : _o_.thiscycledata.entrySet())
/*   65 */       this.thiscycledata.put(_e_.getKey(), _e_.getValue());
/*   66 */     this.curfactionid = _o_.curfactionid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   71 */     this.worshipid = _o_.worshipid;
/*   72 */     this.lastcycledata = new HashMap();
/*   73 */     for (Map.Entry<Long, Integer> _e_ : _o_.lastcycledata.entrySet())
/*   74 */       this.lastcycledata.put(_e_.getKey(), _e_.getValue());
/*   75 */     this.thiscycledata = new HashMap();
/*   76 */     for (Map.Entry<Long, Integer> _e_ : _o_.thiscycledata.entrySet())
/*   77 */       this.thiscycledata.put(_e_.getKey(), _e_.getValue());
/*   78 */     this.curfactionid = _o_.curfactionid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.worshipid);
/*   86 */     _os_.compact_uint32(this.lastcycledata.size());
/*   87 */     for (Map.Entry<Long, Integer> _e_ : this.lastcycledata.entrySet())
/*      */     {
/*   89 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   90 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   92 */     _os_.compact_uint32(this.thiscycledata.size());
/*   93 */     for (Map.Entry<Long, Integer> _e_ : this.thiscycledata.entrySet())
/*      */     {
/*   95 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   96 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   98 */     _os_.marshal(this.curfactionid);
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.worshipid = _os_.unmarshal_int();
/*      */     
/*  108 */     int size = _os_.uncompact_uint32();
/*  109 */     if (size >= 12)
/*      */     {
/*  111 */       this.lastcycledata = new HashMap(size * 2);
/*      */     }
/*  113 */     for (; size > 0; size--)
/*      */     {
/*  115 */       long _k_ = 0L;
/*  116 */       _k_ = _os_.unmarshal_long();
/*  117 */       int _v_ = 0;
/*  118 */       _v_ = _os_.unmarshal_int();
/*  119 */       this.lastcycledata.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  123 */     int size = _os_.uncompact_uint32();
/*  124 */     if (size >= 12)
/*      */     {
/*  126 */       this.thiscycledata = new HashMap(size * 2);
/*      */     }
/*  128 */     for (; size > 0; size--)
/*      */     {
/*  130 */       long _k_ = 0L;
/*  131 */       _k_ = _os_.unmarshal_long();
/*  132 */       int _v_ = 0;
/*  133 */       _v_ = _os_.unmarshal_int();
/*  134 */       this.thiscycledata.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  137 */     this.curfactionid = _os_.unmarshal_long();
/*  138 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     int _size_ = 0;
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(1, this.worshipid);
/*  147 */     for (Map.Entry<Long, Integer> _e_ : this.lastcycledata.entrySet())
/*      */     {
/*  149 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  150 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  152 */     for (Map.Entry<Long, Integer> _e_ : this.thiscycledata.entrySet())
/*      */     {
/*  154 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  155 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  157 */     _size_ += CodedOutputStream.computeInt64Size(4, this.curfactionid);
/*  158 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  167 */       _output_.writeInt32(1, this.worshipid);
/*  168 */       for (Map.Entry<Long, Integer> _e_ : this.lastcycledata.entrySet())
/*      */       {
/*  170 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  171 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  173 */       for (Map.Entry<Long, Integer> _e_ : this.thiscycledata.entrySet())
/*      */       {
/*  175 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  176 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  178 */       _output_.writeInt64(4, this.curfactionid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  182 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  184 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  190 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  193 */       boolean done = false;
/*  194 */       while (!done)
/*      */       {
/*  196 */         int tag = _input_.readTag();
/*  197 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  201 */           done = true;
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  206 */           this.worshipid = _input_.readInt32();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  211 */           long _k_ = 0L;
/*  212 */           _k_ = _input_.readInt64();
/*  213 */           int readTag = _input_.readTag();
/*  214 */           if (16 != readTag)
/*      */           {
/*  216 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  218 */           int _v_ = 0;
/*  219 */           _v_ = _input_.readInt32();
/*  220 */           this.lastcycledata.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  225 */           long _k_ = 0L;
/*  226 */           _k_ = _input_.readInt64();
/*  227 */           int readTag = _input_.readTag();
/*  228 */           if (24 != readTag)
/*      */           {
/*  230 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  232 */           int _v_ = 0;
/*  233 */           _v_ = _input_.readInt32();
/*  234 */           this.thiscycledata.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  239 */           this.curfactionid = _input_.readInt64();
/*  240 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  244 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  246 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  255 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  259 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  261 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleWorshipInfo copy()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new RoleWorshipInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleWorshipInfo toData()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleWorshipInfo toBean()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return new RoleWorshipInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleWorshipInfo toDataIf()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleWorshipInfo toBeanIf()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWorshipid()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this.worshipid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getLastcycledata()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return xdb.Logs.logMap(new LogKey(this, "lastcycledata"), this.lastcycledata);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getLastcycledataAsData()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*      */     
/*  326 */     RoleWorshipInfo _o_ = this;
/*  327 */     Map<Long, Integer> lastcycledata = new HashMap();
/*  328 */     for (Map.Entry<Long, Integer> _e_ : _o_.lastcycledata.entrySet())
/*  329 */       lastcycledata.put(_e_.getKey(), _e_.getValue());
/*  330 */     return lastcycledata;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getThiscycledata()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return xdb.Logs.logMap(new LogKey(this, "thiscycledata"), this.thiscycledata);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getThiscycledataAsData()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*      */     
/*  347 */     RoleWorshipInfo _o_ = this;
/*  348 */     Map<Long, Integer> thiscycledata = new HashMap();
/*  349 */     for (Map.Entry<Long, Integer> _e_ : _o_.thiscycledata.entrySet())
/*  350 */       thiscycledata.put(_e_.getKey(), _e_.getValue());
/*  351 */     return thiscycledata;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCurfactionid()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return this.curfactionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWorshipid(int _v_)
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     xdb.Logs.logIf(new LogKey(this, "worshipid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  371 */         new xdb.logs.LogInt(this, RoleWorshipInfo.this.worshipid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  375 */             RoleWorshipInfo.this.worshipid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  379 */     });
/*  380 */     this.worshipid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurfactionid(long _v_)
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     xdb.Logs.logIf(new LogKey(this, "curfactionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  392 */         new xdb.logs.LogLong(this, RoleWorshipInfo.this.curfactionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  396 */             RoleWorshipInfo.this.curfactionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  400 */     });
/*  401 */     this.curfactionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     RoleWorshipInfo _o_ = null;
/*  409 */     if ((_o1_ instanceof RoleWorshipInfo)) { _o_ = (RoleWorshipInfo)_o1_;
/*  410 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  411 */       return false;
/*  412 */     if (this.worshipid != _o_.worshipid) return false;
/*  413 */     if (!this.lastcycledata.equals(_o_.lastcycledata)) return false;
/*  414 */     if (!this.thiscycledata.equals(_o_.thiscycledata)) return false;
/*  415 */     if (this.curfactionid != _o_.curfactionid) return false;
/*  416 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     int _h_ = 0;
/*  424 */     _h_ += this.worshipid;
/*  425 */     _h_ += this.lastcycledata.hashCode();
/*  426 */     _h_ += this.thiscycledata.hashCode();
/*  427 */     _h_ = (int)(_h_ + this.curfactionid);
/*  428 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*  435 */     StringBuilder _sb_ = new StringBuilder();
/*  436 */     _sb_.append("(");
/*  437 */     _sb_.append(this.worshipid);
/*  438 */     _sb_.append(",");
/*  439 */     _sb_.append(this.lastcycledata);
/*  440 */     _sb_.append(",");
/*  441 */     _sb_.append(this.thiscycledata);
/*  442 */     _sb_.append(",");
/*  443 */     _sb_.append(this.curfactionid);
/*  444 */     _sb_.append(")");
/*  445 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  451 */     ListenableBean lb = new ListenableBean();
/*  452 */     lb.add(new xdb.logs.ListenableChanged().setVarName("worshipid"));
/*  453 */     lb.add(new xdb.logs.ListenableMap().setVarName("lastcycledata"));
/*  454 */     lb.add(new xdb.logs.ListenableMap().setVarName("thiscycledata"));
/*  455 */     lb.add(new xdb.logs.ListenableChanged().setVarName("curfactionid"));
/*  456 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleWorshipInfo {
/*      */     private Const() {}
/*      */     
/*      */     RoleWorshipInfo nThis() {
/*  463 */       return RoleWorshipInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  469 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleWorshipInfo copy()
/*      */     {
/*  475 */       return RoleWorshipInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleWorshipInfo toData()
/*      */     {
/*  481 */       return RoleWorshipInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleWorshipInfo toBean()
/*      */     {
/*  486 */       return RoleWorshipInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleWorshipInfo toDataIf()
/*      */     {
/*  492 */       return RoleWorshipInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleWorshipInfo toBeanIf()
/*      */     {
/*  497 */       return RoleWorshipInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWorshipid()
/*      */     {
/*  504 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  505 */       return RoleWorshipInfo.this.worshipid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getLastcycledata()
/*      */     {
/*  512 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  513 */       return xdb.Consts.constMap(RoleWorshipInfo.this.lastcycledata);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getLastcycledataAsData()
/*      */     {
/*  520 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*      */       
/*  522 */       RoleWorshipInfo _o_ = RoleWorshipInfo.this;
/*  523 */       Map<Long, Integer> lastcycledata = new HashMap();
/*  524 */       for (Map.Entry<Long, Integer> _e_ : _o_.lastcycledata.entrySet())
/*  525 */         lastcycledata.put(_e_.getKey(), _e_.getValue());
/*  526 */       return lastcycledata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getThiscycledata()
/*      */     {
/*  533 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  534 */       return xdb.Consts.constMap(RoleWorshipInfo.this.thiscycledata);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getThiscycledataAsData()
/*      */     {
/*  541 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*      */       
/*  543 */       RoleWorshipInfo _o_ = RoleWorshipInfo.this;
/*  544 */       Map<Long, Integer> thiscycledata = new HashMap();
/*  545 */       for (Map.Entry<Long, Integer> _e_ : _o_.thiscycledata.entrySet())
/*  546 */         thiscycledata.put(_e_.getKey(), _e_.getValue());
/*  547 */       return thiscycledata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCurfactionid()
/*      */     {
/*  554 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  555 */       return RoleWorshipInfo.this.curfactionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorshipid(int _v_)
/*      */     {
/*  562 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  563 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurfactionid(long _v_)
/*      */     {
/*  570 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  571 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  577 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  578 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  584 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  585 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  591 */       return RoleWorshipInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  597 */       return RoleWorshipInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  603 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  604 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  610 */       return RoleWorshipInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  616 */       return RoleWorshipInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  622 */       RoleWorshipInfo.this._xdb_verify_unsafe_();
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  629 */       return RoleWorshipInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  635 */       return RoleWorshipInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  641 */       return RoleWorshipInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  647 */       return RoleWorshipInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  653 */       return RoleWorshipInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  659 */       return RoleWorshipInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  665 */       return RoleWorshipInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleWorshipInfo
/*      */   {
/*      */     private int worshipid;
/*      */     
/*      */     private HashMap<Long, Integer> lastcycledata;
/*      */     
/*      */     private HashMap<Long, Integer> thiscycledata;
/*      */     
/*      */     private long curfactionid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  688 */       this.lastcycledata = new HashMap();
/*  689 */       this.thiscycledata = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.RoleWorshipInfo _o1_)
/*      */     {
/*  694 */       if ((_o1_ instanceof RoleWorshipInfo)) { assign((RoleWorshipInfo)_o1_);
/*  695 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  696 */       } else if ((_o1_ instanceof RoleWorshipInfo.Const)) assign(((RoleWorshipInfo.Const)_o1_).nThis()); else {
/*  697 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleWorshipInfo _o_) {
/*  702 */       this.worshipid = _o_.worshipid;
/*  703 */       this.lastcycledata = new HashMap();
/*  704 */       for (Map.Entry<Long, Integer> _e_ : _o_.lastcycledata.entrySet())
/*  705 */         this.lastcycledata.put(_e_.getKey(), _e_.getValue());
/*  706 */       this.thiscycledata = new HashMap();
/*  707 */       for (Map.Entry<Long, Integer> _e_ : _o_.thiscycledata.entrySet())
/*  708 */         this.thiscycledata.put(_e_.getKey(), _e_.getValue());
/*  709 */       this.curfactionid = _o_.curfactionid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  714 */       this.worshipid = _o_.worshipid;
/*  715 */       this.lastcycledata = new HashMap();
/*  716 */       for (Map.Entry<Long, Integer> _e_ : _o_.lastcycledata.entrySet())
/*  717 */         this.lastcycledata.put(_e_.getKey(), _e_.getValue());
/*  718 */       this.thiscycledata = new HashMap();
/*  719 */       for (Map.Entry<Long, Integer> _e_ : _o_.thiscycledata.entrySet())
/*  720 */         this.thiscycledata.put(_e_.getKey(), _e_.getValue());
/*  721 */       this.curfactionid = _o_.curfactionid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  727 */       _os_.marshal(this.worshipid);
/*  728 */       _os_.compact_uint32(this.lastcycledata.size());
/*  729 */       for (Map.Entry<Long, Integer> _e_ : this.lastcycledata.entrySet())
/*      */       {
/*  731 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  732 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  734 */       _os_.compact_uint32(this.thiscycledata.size());
/*  735 */       for (Map.Entry<Long, Integer> _e_ : this.thiscycledata.entrySet())
/*      */       {
/*  737 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  738 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  740 */       _os_.marshal(this.curfactionid);
/*  741 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  747 */       this.worshipid = _os_.unmarshal_int();
/*      */       
/*  749 */       int size = _os_.uncompact_uint32();
/*  750 */       if (size >= 12)
/*      */       {
/*  752 */         this.lastcycledata = new HashMap(size * 2);
/*      */       }
/*  754 */       for (; size > 0; size--)
/*      */       {
/*  756 */         long _k_ = 0L;
/*  757 */         _k_ = _os_.unmarshal_long();
/*  758 */         int _v_ = 0;
/*  759 */         _v_ = _os_.unmarshal_int();
/*  760 */         this.lastcycledata.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/*  764 */       int size = _os_.uncompact_uint32();
/*  765 */       if (size >= 12)
/*      */       {
/*  767 */         this.thiscycledata = new HashMap(size * 2);
/*      */       }
/*  769 */       for (; size > 0; size--)
/*      */       {
/*  771 */         long _k_ = 0L;
/*  772 */         _k_ = _os_.unmarshal_long();
/*  773 */         int _v_ = 0;
/*  774 */         _v_ = _os_.unmarshal_int();
/*  775 */         this.thiscycledata.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  778 */       this.curfactionid = _os_.unmarshal_long();
/*  779 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  785 */       int _size_ = 0;
/*  786 */       _size_ += CodedOutputStream.computeInt32Size(1, this.worshipid);
/*  787 */       for (Map.Entry<Long, Integer> _e_ : this.lastcycledata.entrySet())
/*      */       {
/*  789 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  790 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  792 */       for (Map.Entry<Long, Integer> _e_ : this.thiscycledata.entrySet())
/*      */       {
/*  794 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  795 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  797 */       _size_ += CodedOutputStream.computeInt64Size(4, this.curfactionid);
/*  798 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  806 */         _output_.writeInt32(1, this.worshipid);
/*  807 */         for (Map.Entry<Long, Integer> _e_ : this.lastcycledata.entrySet())
/*      */         {
/*  809 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  810 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  812 */         for (Map.Entry<Long, Integer> _e_ : this.thiscycledata.entrySet())
/*      */         {
/*  814 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  815 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  817 */         _output_.writeInt64(4, this.curfactionid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  821 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  823 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  831 */         boolean done = false;
/*  832 */         while (!done)
/*      */         {
/*  834 */           int tag = _input_.readTag();
/*  835 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  839 */             done = true;
/*  840 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  844 */             this.worshipid = _input_.readInt32();
/*  845 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  849 */             long _k_ = 0L;
/*  850 */             _k_ = _input_.readInt64();
/*  851 */             int readTag = _input_.readTag();
/*  852 */             if (16 != readTag)
/*      */             {
/*  854 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  856 */             int _v_ = 0;
/*  857 */             _v_ = _input_.readInt32();
/*  858 */             this.lastcycledata.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  859 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  863 */             long _k_ = 0L;
/*  864 */             _k_ = _input_.readInt64();
/*  865 */             int readTag = _input_.readTag();
/*  866 */             if (24 != readTag)
/*      */             {
/*  868 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  870 */             int _v_ = 0;
/*  871 */             _v_ = _input_.readInt32();
/*  872 */             this.thiscycledata.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  873 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  877 */             this.curfactionid = _input_.readInt64();
/*  878 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  882 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  884 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  893 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  897 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  899 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleWorshipInfo copy()
/*      */     {
/*  905 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleWorshipInfo toData()
/*      */     {
/*  911 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleWorshipInfo toBean()
/*      */     {
/*  916 */       return new RoleWorshipInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleWorshipInfo toDataIf()
/*      */     {
/*  922 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleWorshipInfo toBeanIf()
/*      */     {
/*  927 */       return new RoleWorshipInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  949 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  953 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  957 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWorshipid()
/*      */     {
/*  964 */       return this.worshipid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getLastcycledata()
/*      */     {
/*  971 */       return this.lastcycledata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getLastcycledataAsData()
/*      */     {
/*  978 */       return this.lastcycledata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getThiscycledata()
/*      */     {
/*  985 */       return this.thiscycledata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getThiscycledataAsData()
/*      */     {
/*  992 */       return this.thiscycledata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCurfactionid()
/*      */     {
/*  999 */       return this.curfactionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorshipid(int _v_)
/*      */     {
/* 1006 */       this.worshipid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurfactionid(long _v_)
/*      */     {
/* 1013 */       this.curfactionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1019 */       if (!(_o1_ instanceof Data)) return false;
/* 1020 */       Data _o_ = (Data)_o1_;
/* 1021 */       if (this.worshipid != _o_.worshipid) return false;
/* 1022 */       if (!this.lastcycledata.equals(_o_.lastcycledata)) return false;
/* 1023 */       if (!this.thiscycledata.equals(_o_.thiscycledata)) return false;
/* 1024 */       if (this.curfactionid != _o_.curfactionid) return false;
/* 1025 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1031 */       int _h_ = 0;
/* 1032 */       _h_ += this.worshipid;
/* 1033 */       _h_ += this.lastcycledata.hashCode();
/* 1034 */       _h_ += this.thiscycledata.hashCode();
/* 1035 */       _h_ = (int)(_h_ + this.curfactionid);
/* 1036 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1042 */       StringBuilder _sb_ = new StringBuilder();
/* 1043 */       _sb_.append("(");
/* 1044 */       _sb_.append(this.worshipid);
/* 1045 */       _sb_.append(",");
/* 1046 */       _sb_.append(this.lastcycledata);
/* 1047 */       _sb_.append(",");
/* 1048 */       _sb_.append(this.thiscycledata);
/* 1049 */       _sb_.append(",");
/* 1050 */       _sb_.append(this.curfactionid);
/* 1051 */       _sb_.append(")");
/* 1052 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleWorshipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */