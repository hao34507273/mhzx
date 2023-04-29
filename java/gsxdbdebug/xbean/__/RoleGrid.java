/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class RoleGrid extends XBean implements xbean.RoleGrid
/*      */ {
/*      */   private int maxgridnum;
/*      */   private long lastrefreshtime;
/*      */   private HashMap<Long, Long> shoppingid2channelid;
/*      */   private SetX<Long> needrecycleshoppingids;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.maxgridnum = 0;
/*   25 */     this.lastrefreshtime = 0L;
/*   26 */     this.shoppingid2channelid.clear();
/*   27 */     this.needrecycleshoppingids.clear();
/*      */   }
/*      */   
/*      */   RoleGrid(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.shoppingid2channelid = new HashMap();
/*   34 */     this.needrecycleshoppingids = new SetX();
/*      */   }
/*      */   
/*      */   public RoleGrid()
/*      */   {
/*   39 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleGrid(RoleGrid _o_)
/*      */   {
/*   44 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleGrid(xbean.RoleGrid _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   49 */     super(_xp_, _vn_);
/*   50 */     if ((_o1_ instanceof RoleGrid)) { assign((RoleGrid)_o1_);
/*   51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   53 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleGrid _o_) {
/*   58 */     _o_._xdb_verify_unsafe_();
/*   59 */     this.maxgridnum = _o_.maxgridnum;
/*   60 */     this.lastrefreshtime = _o_.lastrefreshtime;
/*   61 */     this.shoppingid2channelid = new HashMap();
/*   62 */     for (Map.Entry<Long, Long> _e_ : _o_.shoppingid2channelid.entrySet())
/*   63 */       this.shoppingid2channelid.put(_e_.getKey(), _e_.getValue());
/*   64 */     this.needrecycleshoppingids = new SetX();
/*   65 */     this.needrecycleshoppingids.addAll(_o_.needrecycleshoppingids);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   70 */     this.maxgridnum = _o_.maxgridnum;
/*   71 */     this.lastrefreshtime = _o_.lastrefreshtime;
/*   72 */     this.shoppingid2channelid = new HashMap();
/*   73 */     for (Map.Entry<Long, Long> _e_ : _o_.shoppingid2channelid.entrySet())
/*   74 */       this.shoppingid2channelid.put(_e_.getKey(), _e_.getValue());
/*   75 */     this.needrecycleshoppingids = new SetX();
/*   76 */     this.needrecycleshoppingids.addAll(_o_.needrecycleshoppingids);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   82 */     _xdb_verify_unsafe_();
/*   83 */     _os_.marshal(this.maxgridnum);
/*   84 */     _os_.marshal(this.lastrefreshtime);
/*   85 */     _os_.compact_uint32(this.shoppingid2channelid.size());
/*   86 */     for (Map.Entry<Long, Long> _e_ : this.shoppingid2channelid.entrySet())
/*      */     {
/*   88 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   89 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*   91 */     _os_.compact_uint32(this.needrecycleshoppingids.size());
/*   92 */     for (Long _v_ : this.needrecycleshoppingids)
/*      */     {
/*   94 */       _os_.marshal(_v_.longValue());
/*      */     }
/*   96 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  102 */     _xdb_verify_unsafe_();
/*  103 */     this.maxgridnum = _os_.unmarshal_int();
/*  104 */     this.lastrefreshtime = _os_.unmarshal_long();
/*      */     
/*  106 */     int size = _os_.uncompact_uint32();
/*  107 */     if (size >= 12)
/*      */     {
/*  109 */       this.shoppingid2channelid = new HashMap(size * 2);
/*      */     }
/*  111 */     for (; size > 0; size--)
/*      */     {
/*  113 */       long _k_ = 0L;
/*  114 */       _k_ = _os_.unmarshal_long();
/*  115 */       long _v_ = 0L;
/*  116 */       _v_ = _os_.unmarshal_long();
/*  117 */       this.shoppingid2channelid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*  120 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  122 */       long _v_ = 0L;
/*  123 */       _v_ = _os_.unmarshal_long();
/*  124 */       this.needrecycleshoppingids.add(Long.valueOf(_v_));
/*      */     }
/*  126 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*  133 */     int _size_ = 0;
/*  134 */     _size_ += CodedOutputStream.computeInt32Size(1, this.maxgridnum);
/*  135 */     _size_ += CodedOutputStream.computeInt64Size(2, this.lastrefreshtime);
/*  136 */     for (Map.Entry<Long, Long> _e_ : this.shoppingid2channelid.entrySet())
/*      */     {
/*  138 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  139 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  141 */     for (Long _v_ : this.needrecycleshoppingids)
/*      */     {
/*  143 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  145 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  151 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  154 */       _output_.writeInt32(1, this.maxgridnum);
/*  155 */       _output_.writeInt64(2, this.lastrefreshtime);
/*  156 */       for (Map.Entry<Long, Long> _e_ : this.shoppingid2channelid.entrySet())
/*      */       {
/*  158 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  159 */         _output_.writeInt64(3, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  161 */       for (Long _v_ : this.needrecycleshoppingids)
/*      */       {
/*  163 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  168 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  170 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  176 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  179 */       boolean done = false;
/*  180 */       while (!done)
/*      */       {
/*  182 */         int tag = _input_.readTag();
/*  183 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  187 */           done = true;
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  192 */           this.maxgridnum = _input_.readInt32();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  197 */           this.lastrefreshtime = _input_.readInt64();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  202 */           long _k_ = 0L;
/*  203 */           _k_ = _input_.readInt64();
/*  204 */           int readTag = _input_.readTag();
/*  205 */           if (24 != readTag)
/*      */           {
/*  207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  209 */           long _v_ = 0L;
/*  210 */           _v_ = _input_.readInt64();
/*  211 */           this.shoppingid2channelid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  216 */           long _v_ = 0L;
/*  217 */           _v_ = _input_.readInt64();
/*  218 */           this.needrecycleshoppingids.add(Long.valueOf(_v_));
/*  219 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  223 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  225 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  234 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  238 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  240 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleGrid copy()
/*      */   {
/*  246 */     _xdb_verify_unsafe_();
/*  247 */     return new RoleGrid(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleGrid toData()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleGrid toBean()
/*      */   {
/*  259 */     _xdb_verify_unsafe_();
/*  260 */     return new RoleGrid(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleGrid toDataIf()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleGrid toBeanIf()
/*      */   {
/*  272 */     _xdb_verify_unsafe_();
/*  273 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMaxgridnum()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return this.maxgridnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastrefreshtime()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return this.lastrefreshtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public java.util.Map<Long, Long> getShoppingid2channelid()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return xdb.Logs.logMap(new LogKey(this, "shoppingid2channelid"), this.shoppingid2channelid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public java.util.Map<Long, Long> getShoppingid2channelidAsData()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*      */     
/*  313 */     RoleGrid _o_ = this;
/*  314 */     java.util.Map<Long, Long> shoppingid2channelid = new HashMap();
/*  315 */     for (Map.Entry<Long, Long> _e_ : _o_.shoppingid2channelid.entrySet())
/*  316 */       shoppingid2channelid.put(_e_.getKey(), _e_.getValue());
/*  317 */     return shoppingid2channelid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getNeedrecycleshoppingids()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return xdb.Logs.logSet(new LogKey(this, "needrecycleshoppingids"), this.needrecycleshoppingids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getNeedrecycleshoppingidsAsData()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*      */     
/*  333 */     RoleGrid _o_ = this;
/*  334 */     Set<Long> needrecycleshoppingids = new SetX();
/*  335 */     needrecycleshoppingids.addAll(_o_.needrecycleshoppingids);
/*  336 */     return needrecycleshoppingids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMaxgridnum(int _v_)
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     xdb.Logs.logIf(new LogKey(this, "maxgridnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  348 */         new xdb.logs.LogInt(this, RoleGrid.this.maxgridnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  352 */             RoleGrid.this.maxgridnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  356 */     });
/*  357 */     this.maxgridnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastrefreshtime(long _v_)
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     xdb.Logs.logIf(new LogKey(this, "lastrefreshtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  369 */         new xdb.logs.LogLong(this, RoleGrid.this.lastrefreshtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  373 */             RoleGrid.this.lastrefreshtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  377 */     });
/*  378 */     this.lastrefreshtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     RoleGrid _o_ = null;
/*  386 */     if ((_o1_ instanceof RoleGrid)) { _o_ = (RoleGrid)_o1_;
/*  387 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  388 */       return false;
/*  389 */     if (this.maxgridnum != _o_.maxgridnum) return false;
/*  390 */     if (this.lastrefreshtime != _o_.lastrefreshtime) return false;
/*  391 */     if (!this.shoppingid2channelid.equals(_o_.shoppingid2channelid)) return false;
/*  392 */     if (!this.needrecycleshoppingids.equals(_o_.needrecycleshoppingids)) return false;
/*  393 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     int _h_ = 0;
/*  401 */     _h_ += this.maxgridnum;
/*  402 */     _h_ = (int)(_h_ + this.lastrefreshtime);
/*  403 */     _h_ += this.shoppingid2channelid.hashCode();
/*  404 */     _h_ += this.needrecycleshoppingids.hashCode();
/*  405 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     StringBuilder _sb_ = new StringBuilder();
/*  413 */     _sb_.append("(");
/*  414 */     _sb_.append(this.maxgridnum);
/*  415 */     _sb_.append(",");
/*  416 */     _sb_.append(this.lastrefreshtime);
/*  417 */     _sb_.append(",");
/*  418 */     _sb_.append(this.shoppingid2channelid);
/*  419 */     _sb_.append(",");
/*  420 */     _sb_.append(this.needrecycleshoppingids);
/*  421 */     _sb_.append(")");
/*  422 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  428 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  429 */     lb.add(new xdb.logs.ListenableChanged().setVarName("maxgridnum"));
/*  430 */     lb.add(new xdb.logs.ListenableChanged().setVarName("lastrefreshtime"));
/*  431 */     lb.add(new xdb.logs.ListenableMap().setVarName("shoppingid2channelid"));
/*  432 */     lb.add(new xdb.logs.ListenableSet().setVarName("needrecycleshoppingids"));
/*  433 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleGrid {
/*      */     private Const() {}
/*      */     
/*      */     RoleGrid nThis() {
/*  440 */       return RoleGrid.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  446 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGrid copy()
/*      */     {
/*  452 */       return RoleGrid.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGrid toData()
/*      */     {
/*  458 */       return RoleGrid.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleGrid toBean()
/*      */     {
/*  463 */       return RoleGrid.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGrid toDataIf()
/*      */     {
/*  469 */       return RoleGrid.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleGrid toBeanIf()
/*      */     {
/*  474 */       return RoleGrid.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxgridnum()
/*      */     {
/*  481 */       RoleGrid.this._xdb_verify_unsafe_();
/*  482 */       return RoleGrid.this.maxgridnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastrefreshtime()
/*      */     {
/*  489 */       RoleGrid.this._xdb_verify_unsafe_();
/*  490 */       return RoleGrid.this.lastrefreshtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Map<Long, Long> getShoppingid2channelid()
/*      */     {
/*  497 */       RoleGrid.this._xdb_verify_unsafe_();
/*  498 */       return xdb.Consts.constMap(RoleGrid.this.shoppingid2channelid);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Map<Long, Long> getShoppingid2channelidAsData()
/*      */     {
/*  505 */       RoleGrid.this._xdb_verify_unsafe_();
/*      */       
/*  507 */       RoleGrid _o_ = RoleGrid.this;
/*  508 */       java.util.Map<Long, Long> shoppingid2channelid = new HashMap();
/*  509 */       for (Map.Entry<Long, Long> _e_ : _o_.shoppingid2channelid.entrySet())
/*  510 */         shoppingid2channelid.put(_e_.getKey(), _e_.getValue());
/*  511 */       return shoppingid2channelid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getNeedrecycleshoppingids()
/*      */     {
/*  518 */       RoleGrid.this._xdb_verify_unsafe_();
/*  519 */       return xdb.Consts.constSet(RoleGrid.this.needrecycleshoppingids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getNeedrecycleshoppingidsAsData()
/*      */     {
/*  525 */       RoleGrid.this._xdb_verify_unsafe_();
/*      */       
/*  527 */       RoleGrid _o_ = RoleGrid.this;
/*  528 */       Set<Long> needrecycleshoppingids = new SetX();
/*  529 */       needrecycleshoppingids.addAll(_o_.needrecycleshoppingids);
/*  530 */       return needrecycleshoppingids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxgridnum(int _v_)
/*      */     {
/*  537 */       RoleGrid.this._xdb_verify_unsafe_();
/*  538 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastrefreshtime(long _v_)
/*      */     {
/*  545 */       RoleGrid.this._xdb_verify_unsafe_();
/*  546 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  552 */       RoleGrid.this._xdb_verify_unsafe_();
/*  553 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  559 */       RoleGrid.this._xdb_verify_unsafe_();
/*  560 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  566 */       return RoleGrid.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  572 */       return RoleGrid.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  578 */       RoleGrid.this._xdb_verify_unsafe_();
/*  579 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  585 */       return RoleGrid.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  591 */       return RoleGrid.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  597 */       RoleGrid.this._xdb_verify_unsafe_();
/*  598 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  604 */       return RoleGrid.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  610 */       return RoleGrid.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  616 */       return RoleGrid.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  622 */       return RoleGrid.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  628 */       return RoleGrid.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  634 */       return RoleGrid.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  640 */       return RoleGrid.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleGrid
/*      */   {
/*      */     private int maxgridnum;
/*      */     
/*      */     private long lastrefreshtime;
/*      */     
/*      */     private HashMap<Long, Long> shoppingid2channelid;
/*      */     
/*      */     private HashSet<Long> needrecycleshoppingids;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  658 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  663 */       this.shoppingid2channelid = new HashMap();
/*  664 */       this.needrecycleshoppingids = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.RoleGrid _o1_)
/*      */     {
/*  669 */       if ((_o1_ instanceof RoleGrid)) { assign((RoleGrid)_o1_);
/*  670 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  671 */       } else if ((_o1_ instanceof RoleGrid.Const)) assign(((RoleGrid.Const)_o1_).nThis()); else {
/*  672 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleGrid _o_) {
/*  677 */       this.maxgridnum = _o_.maxgridnum;
/*  678 */       this.lastrefreshtime = _o_.lastrefreshtime;
/*  679 */       this.shoppingid2channelid = new HashMap();
/*  680 */       for (Map.Entry<Long, Long> _e_ : _o_.shoppingid2channelid.entrySet())
/*  681 */         this.shoppingid2channelid.put(_e_.getKey(), _e_.getValue());
/*  682 */       this.needrecycleshoppingids = new HashSet();
/*  683 */       this.needrecycleshoppingids.addAll(_o_.needrecycleshoppingids);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  688 */       this.maxgridnum = _o_.maxgridnum;
/*  689 */       this.lastrefreshtime = _o_.lastrefreshtime;
/*  690 */       this.shoppingid2channelid = new HashMap();
/*  691 */       for (Map.Entry<Long, Long> _e_ : _o_.shoppingid2channelid.entrySet())
/*  692 */         this.shoppingid2channelid.put(_e_.getKey(), _e_.getValue());
/*  693 */       this.needrecycleshoppingids = new HashSet();
/*  694 */       this.needrecycleshoppingids.addAll(_o_.needrecycleshoppingids);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  700 */       _os_.marshal(this.maxgridnum);
/*  701 */       _os_.marshal(this.lastrefreshtime);
/*  702 */       _os_.compact_uint32(this.shoppingid2channelid.size());
/*  703 */       for (Map.Entry<Long, Long> _e_ : this.shoppingid2channelid.entrySet())
/*      */       {
/*  705 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  706 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/*  708 */       _os_.compact_uint32(this.needrecycleshoppingids.size());
/*  709 */       for (Long _v_ : this.needrecycleshoppingids)
/*      */       {
/*  711 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  713 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  719 */       this.maxgridnum = _os_.unmarshal_int();
/*  720 */       this.lastrefreshtime = _os_.unmarshal_long();
/*      */       
/*  722 */       int size = _os_.uncompact_uint32();
/*  723 */       if (size >= 12)
/*      */       {
/*  725 */         this.shoppingid2channelid = new HashMap(size * 2);
/*      */       }
/*  727 */       for (; size > 0; size--)
/*      */       {
/*  729 */         long _k_ = 0L;
/*  730 */         _k_ = _os_.unmarshal_long();
/*  731 */         long _v_ = 0L;
/*  732 */         _v_ = _os_.unmarshal_long();
/*  733 */         this.shoppingid2channelid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/*  736 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  738 */         long _v_ = 0L;
/*  739 */         _v_ = _os_.unmarshal_long();
/*  740 */         this.needrecycleshoppingids.add(Long.valueOf(_v_));
/*      */       }
/*  742 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  748 */       int _size_ = 0;
/*  749 */       _size_ += CodedOutputStream.computeInt32Size(1, this.maxgridnum);
/*  750 */       _size_ += CodedOutputStream.computeInt64Size(2, this.lastrefreshtime);
/*  751 */       for (Map.Entry<Long, Long> _e_ : this.shoppingid2channelid.entrySet())
/*      */       {
/*  753 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  754 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  756 */       for (Long _v_ : this.needrecycleshoppingids)
/*      */       {
/*  758 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/*  760 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  768 */         _output_.writeInt32(1, this.maxgridnum);
/*  769 */         _output_.writeInt64(2, this.lastrefreshtime);
/*  770 */         for (Map.Entry<Long, Long> _e_ : this.shoppingid2channelid.entrySet())
/*      */         {
/*  772 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  773 */           _output_.writeInt64(3, ((Long)_e_.getValue()).longValue());
/*      */         }
/*  775 */         for (Long _v_ : this.needrecycleshoppingids)
/*      */         {
/*  777 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  782 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  784 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  792 */         boolean done = false;
/*  793 */         while (!done)
/*      */         {
/*  795 */           int tag = _input_.readTag();
/*  796 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  800 */             done = true;
/*  801 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  805 */             this.maxgridnum = _input_.readInt32();
/*  806 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  810 */             this.lastrefreshtime = _input_.readInt64();
/*  811 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  815 */             long _k_ = 0L;
/*  816 */             _k_ = _input_.readInt64();
/*  817 */             int readTag = _input_.readTag();
/*  818 */             if (24 != readTag)
/*      */             {
/*  820 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  822 */             long _v_ = 0L;
/*  823 */             _v_ = _input_.readInt64();
/*  824 */             this.shoppingid2channelid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*  825 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  829 */             long _v_ = 0L;
/*  830 */             _v_ = _input_.readInt64();
/*  831 */             this.needrecycleshoppingids.add(Long.valueOf(_v_));
/*  832 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  836 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  838 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  847 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  851 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  853 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGrid copy()
/*      */     {
/*  859 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGrid toData()
/*      */     {
/*  865 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleGrid toBean()
/*      */     {
/*  870 */       return new RoleGrid(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGrid toDataIf()
/*      */     {
/*  876 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleGrid toBeanIf()
/*      */     {
/*  881 */       return new RoleGrid(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  887 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  891 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  895 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  903 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  907 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  911 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxgridnum()
/*      */     {
/*  918 */       return this.maxgridnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastrefreshtime()
/*      */     {
/*  925 */       return this.lastrefreshtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Map<Long, Long> getShoppingid2channelid()
/*      */     {
/*  932 */       return this.shoppingid2channelid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Map<Long, Long> getShoppingid2channelidAsData()
/*      */     {
/*  939 */       return this.shoppingid2channelid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getNeedrecycleshoppingids()
/*      */     {
/*  946 */       return this.needrecycleshoppingids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getNeedrecycleshoppingidsAsData()
/*      */     {
/*  953 */       return this.needrecycleshoppingids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxgridnum(int _v_)
/*      */     {
/*  960 */       this.maxgridnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastrefreshtime(long _v_)
/*      */     {
/*  967 */       this.lastrefreshtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  973 */       if (!(_o1_ instanceof Data)) return false;
/*  974 */       Data _o_ = (Data)_o1_;
/*  975 */       if (this.maxgridnum != _o_.maxgridnum) return false;
/*  976 */       if (this.lastrefreshtime != _o_.lastrefreshtime) return false;
/*  977 */       if (!this.shoppingid2channelid.equals(_o_.shoppingid2channelid)) return false;
/*  978 */       if (!this.needrecycleshoppingids.equals(_o_.needrecycleshoppingids)) return false;
/*  979 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/*  985 */       int _h_ = 0;
/*  986 */       _h_ += this.maxgridnum;
/*  987 */       _h_ = (int)(_h_ + this.lastrefreshtime);
/*  988 */       _h_ += this.shoppingid2channelid.hashCode();
/*  989 */       _h_ += this.needrecycleshoppingids.hashCode();
/*  990 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  996 */       StringBuilder _sb_ = new StringBuilder();
/*  997 */       _sb_.append("(");
/*  998 */       _sb_.append(this.maxgridnum);
/*  999 */       _sb_.append(",");
/* 1000 */       _sb_.append(this.lastrefreshtime);
/* 1001 */       _sb_.append(",");
/* 1002 */       _sb_.append(this.shoppingid2channelid);
/* 1003 */       _sb_.append(",");
/* 1004 */       _sb_.append(this.needrecycleshoppingids);
/* 1005 */       _sb_.append(")");
/* 1006 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleGrid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */