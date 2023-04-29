/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class InstanceCacheBean extends XBean implements xbean.InstanceCacheBean
/*      */ {
/*      */   private int instancecfgid;
/*      */   private long worldid;
/*      */   private long opentime;
/*      */   private ArrayList<Long> roleids;
/*      */   private ArrayList<Long> sucroleids;
/*      */   private HashMap<Integer, Integer> extra;
/*      */   private SetX<Long> finishroleids;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.instancecfgid = 0;
/*   31 */     this.worldid = 0L;
/*   32 */     this.opentime = 0L;
/*   33 */     this.roleids.clear();
/*   34 */     this.sucroleids.clear();
/*   35 */     this.extra.clear();
/*   36 */     this.finishroleids.clear();
/*      */   }
/*      */   
/*      */   InstanceCacheBean(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.roleids = new ArrayList();
/*   43 */     this.sucroleids = new ArrayList();
/*   44 */     this.extra = new HashMap();
/*   45 */     this.finishroleids = new SetX();
/*      */   }
/*      */   
/*      */   public InstanceCacheBean()
/*      */   {
/*   50 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public InstanceCacheBean(InstanceCacheBean _o_)
/*      */   {
/*   55 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   InstanceCacheBean(xbean.InstanceCacheBean _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   60 */     super(_xp_, _vn_);
/*   61 */     if ((_o1_ instanceof InstanceCacheBean)) { assign((InstanceCacheBean)_o1_);
/*   62 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   63 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   64 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(InstanceCacheBean _o_) {
/*   69 */     _o_._xdb_verify_unsafe_();
/*   70 */     this.instancecfgid = _o_.instancecfgid;
/*   71 */     this.worldid = _o_.worldid;
/*   72 */     this.opentime = _o_.opentime;
/*   73 */     this.roleids = new ArrayList();
/*   74 */     this.roleids.addAll(_o_.roleids);
/*   75 */     this.sucroleids = new ArrayList();
/*   76 */     this.sucroleids.addAll(_o_.sucroleids);
/*   77 */     this.extra = new HashMap();
/*   78 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*   79 */       this.extra.put(_e_.getKey(), _e_.getValue());
/*   80 */     this.finishroleids = new SetX();
/*   81 */     this.finishroleids.addAll(_o_.finishroleids);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   86 */     this.instancecfgid = _o_.instancecfgid;
/*   87 */     this.worldid = _o_.worldid;
/*   88 */     this.opentime = _o_.opentime;
/*   89 */     this.roleids = new ArrayList();
/*   90 */     this.roleids.addAll(_o_.roleids);
/*   91 */     this.sucroleids = new ArrayList();
/*   92 */     this.sucroleids.addAll(_o_.sucroleids);
/*   93 */     this.extra = new HashMap();
/*   94 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*   95 */       this.extra.put(_e_.getKey(), _e_.getValue());
/*   96 */     this.finishroleids = new SetX();
/*   97 */     this.finishroleids.addAll(_o_.finishroleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     _os_.marshal(this.instancecfgid);
/*  105 */     _os_.marshal(this.worldid);
/*  106 */     _os_.marshal(this.opentime);
/*  107 */     _os_.compact_uint32(this.roleids.size());
/*  108 */     for (Long _v_ : this.roleids)
/*      */     {
/*  110 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  112 */     _os_.compact_uint32(this.sucroleids.size());
/*  113 */     for (Long _v_ : this.sucroleids)
/*      */     {
/*  115 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  117 */     _os_.compact_uint32(this.extra.size());
/*  118 */     for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */     {
/*  120 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  121 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  123 */     _os_.compact_uint32(this.finishroleids.size());
/*  124 */     for (Long _v_ : this.finishroleids)
/*      */     {
/*  126 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  128 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  134 */     _xdb_verify_unsafe_();
/*  135 */     this.instancecfgid = _os_.unmarshal_int();
/*  136 */     this.worldid = _os_.unmarshal_long();
/*  137 */     this.opentime = _os_.unmarshal_long();
/*  138 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  140 */       long _v_ = 0L;
/*  141 */       _v_ = _os_.unmarshal_long();
/*  142 */       this.roleids.add(Long.valueOf(_v_));
/*      */     }
/*  144 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  146 */       long _v_ = 0L;
/*  147 */       _v_ = _os_.unmarshal_long();
/*  148 */       this.sucroleids.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  151 */     int size = _os_.uncompact_uint32();
/*  152 */     if (size >= 12)
/*      */     {
/*  154 */       this.extra = new HashMap(size * 2);
/*      */     }
/*  156 */     for (; size > 0; size--)
/*      */     {
/*  158 */       int _k_ = 0;
/*  159 */       _k_ = _os_.unmarshal_int();
/*  160 */       int _v_ = 0;
/*  161 */       _v_ = _os_.unmarshal_int();
/*  162 */       this.extra.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  165 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  167 */       long _v_ = 0L;
/*  168 */       _v_ = _os_.unmarshal_long();
/*  169 */       this.finishroleids.add(Long.valueOf(_v_));
/*      */     }
/*  171 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  177 */     _xdb_verify_unsafe_();
/*  178 */     int _size_ = 0;
/*  179 */     _size_ += CodedOutputStream.computeInt32Size(1, this.instancecfgid);
/*  180 */     _size_ += CodedOutputStream.computeInt64Size(2, this.worldid);
/*  181 */     _size_ += CodedOutputStream.computeInt64Size(3, this.opentime);
/*  182 */     for (Long _v_ : this.roleids)
/*      */     {
/*  184 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  186 */     for (Long _v_ : this.sucroleids)
/*      */     {
/*  188 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  190 */     for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */     {
/*  192 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  193 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  195 */     for (Long _v_ : this.finishroleids)
/*      */     {
/*  197 */       _size_ += CodedOutputStream.computeInt64Size(7, _v_.longValue());
/*      */     }
/*  199 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  205 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  208 */       _output_.writeInt32(1, this.instancecfgid);
/*  209 */       _output_.writeInt64(2, this.worldid);
/*  210 */       _output_.writeInt64(3, this.opentime);
/*  211 */       for (Long _v_ : this.roleids)
/*      */       {
/*  213 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*  215 */       for (Long _v_ : this.sucroleids)
/*      */       {
/*  217 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*  219 */       for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */       {
/*  221 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  222 */         _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  224 */       for (Long _v_ : this.finishroleids)
/*      */       {
/*  226 */         _output_.writeInt64(7, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  231 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  233 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  242 */       boolean done = false;
/*  243 */       while (!done)
/*      */       {
/*  245 */         int tag = _input_.readTag();
/*  246 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  250 */           done = true;
/*  251 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  255 */           this.instancecfgid = _input_.readInt32();
/*  256 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  260 */           this.worldid = _input_.readInt64();
/*  261 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  265 */           this.opentime = _input_.readInt64();
/*  266 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  270 */           long _v_ = 0L;
/*  271 */           _v_ = _input_.readInt64();
/*  272 */           this.roleids.add(Long.valueOf(_v_));
/*  273 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  277 */           long _v_ = 0L;
/*  278 */           _v_ = _input_.readInt64();
/*  279 */           this.sucroleids.add(Long.valueOf(_v_));
/*  280 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  284 */           int _k_ = 0;
/*  285 */           _k_ = _input_.readInt32();
/*  286 */           int readTag = _input_.readTag();
/*  287 */           if (48 != readTag)
/*      */           {
/*  289 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  291 */           int _v_ = 0;
/*  292 */           _v_ = _input_.readInt32();
/*  293 */           this.extra.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  294 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  298 */           long _v_ = 0L;
/*  299 */           _v_ = _input_.readInt64();
/*  300 */           this.finishroleids.add(Long.valueOf(_v_));
/*  301 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  305 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  307 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  316 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  320 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  322 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.InstanceCacheBean copy()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return new InstanceCacheBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.InstanceCacheBean toData()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.InstanceCacheBean toBean()
/*      */   {
/*  341 */     _xdb_verify_unsafe_();
/*  342 */     return new InstanceCacheBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.InstanceCacheBean toDataIf()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.InstanceCacheBean toBeanIf()
/*      */   {
/*  354 */     _xdb_verify_unsafe_();
/*  355 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getInstancecfgid()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return this.instancecfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWorldid()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return this.worldid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOpentime()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return this.opentime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getRoleids()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return xdb.Logs.logList(new LogKey(this, "roleids"), this.roleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getRoleidsAsData()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*      */     
/*  402 */     InstanceCacheBean _o_ = this;
/*  403 */     List<Long> roleids = new ArrayList();
/*  404 */     roleids.addAll(_o_.roleids);
/*  405 */     return roleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getSucroleids()
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     return xdb.Logs.logList(new LogKey(this, "sucroleids"), this.sucroleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getSucroleidsAsData()
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*      */     
/*  421 */     InstanceCacheBean _o_ = this;
/*  422 */     List<Long> sucroleids = new ArrayList();
/*  423 */     sucroleids.addAll(_o_.sucroleids);
/*  424 */     return sucroleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtra()
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     return xdb.Logs.logMap(new LogKey(this, "extra"), this.extra);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtraAsData()
/*      */   {
/*  439 */     _xdb_verify_unsafe_();
/*      */     
/*  441 */     InstanceCacheBean _o_ = this;
/*  442 */     Map<Integer, Integer> extra = new HashMap();
/*  443 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*  444 */       extra.put(_e_.getKey(), _e_.getValue());
/*  445 */     return extra;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getFinishroleids()
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     return xdb.Logs.logSet(new LogKey(this, "finishroleids"), this.finishroleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getFinishroleidsAsData()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*      */     
/*  461 */     InstanceCacheBean _o_ = this;
/*  462 */     Set<Long> finishroleids = new SetX();
/*  463 */     finishroleids.addAll(_o_.finishroleids);
/*  464 */     return finishroleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInstancecfgid(int _v_)
/*      */   {
/*  471 */     _xdb_verify_unsafe_();
/*  472 */     xdb.Logs.logIf(new LogKey(this, "instancecfgid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  476 */         new xdb.logs.LogInt(this, InstanceCacheBean.this.instancecfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  480 */             InstanceCacheBean.this.instancecfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  484 */     });
/*  485 */     this.instancecfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWorldid(long _v_)
/*      */   {
/*  492 */     _xdb_verify_unsafe_();
/*  493 */     xdb.Logs.logIf(new LogKey(this, "worldid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  497 */         new xdb.logs.LogLong(this, InstanceCacheBean.this.worldid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  501 */             InstanceCacheBean.this.worldid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  505 */     });
/*  506 */     this.worldid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOpentime(long _v_)
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     xdb.Logs.logIf(new LogKey(this, "opentime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  518 */         new xdb.logs.LogLong(this, InstanceCacheBean.this.opentime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  522 */             InstanceCacheBean.this.opentime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  526 */     });
/*  527 */     this.opentime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  533 */     _xdb_verify_unsafe_();
/*  534 */     InstanceCacheBean _o_ = null;
/*  535 */     if ((_o1_ instanceof InstanceCacheBean)) { _o_ = (InstanceCacheBean)_o1_;
/*  536 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  537 */       return false;
/*  538 */     if (this.instancecfgid != _o_.instancecfgid) return false;
/*  539 */     if (this.worldid != _o_.worldid) return false;
/*  540 */     if (this.opentime != _o_.opentime) return false;
/*  541 */     if (!this.roleids.equals(_o_.roleids)) return false;
/*  542 */     if (!this.sucroleids.equals(_o_.sucroleids)) return false;
/*  543 */     if (!this.extra.equals(_o_.extra)) return false;
/*  544 */     if (!this.finishroleids.equals(_o_.finishroleids)) return false;
/*  545 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*  552 */     int _h_ = 0;
/*  553 */     _h_ += this.instancecfgid;
/*  554 */     _h_ = (int)(_h_ + this.worldid);
/*  555 */     _h_ = (int)(_h_ + this.opentime);
/*  556 */     _h_ += this.roleids.hashCode();
/*  557 */     _h_ += this.sucroleids.hashCode();
/*  558 */     _h_ += this.extra.hashCode();
/*  559 */     _h_ += this.finishroleids.hashCode();
/*  560 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  566 */     _xdb_verify_unsafe_();
/*  567 */     StringBuilder _sb_ = new StringBuilder();
/*  568 */     _sb_.append("(");
/*  569 */     _sb_.append(this.instancecfgid);
/*  570 */     _sb_.append(",");
/*  571 */     _sb_.append(this.worldid);
/*  572 */     _sb_.append(",");
/*  573 */     _sb_.append(this.opentime);
/*  574 */     _sb_.append(",");
/*  575 */     _sb_.append(this.roleids);
/*  576 */     _sb_.append(",");
/*  577 */     _sb_.append(this.sucroleids);
/*  578 */     _sb_.append(",");
/*  579 */     _sb_.append(this.extra);
/*  580 */     _sb_.append(",");
/*  581 */     _sb_.append(this.finishroleids);
/*  582 */     _sb_.append(")");
/*  583 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  589 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  590 */     lb.add(new xdb.logs.ListenableChanged().setVarName("instancecfgid"));
/*  591 */     lb.add(new xdb.logs.ListenableChanged().setVarName("worldid"));
/*  592 */     lb.add(new xdb.logs.ListenableChanged().setVarName("opentime"));
/*  593 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleids"));
/*  594 */     lb.add(new xdb.logs.ListenableChanged().setVarName("sucroleids"));
/*  595 */     lb.add(new xdb.logs.ListenableMap().setVarName("extra"));
/*  596 */     lb.add(new xdb.logs.ListenableSet().setVarName("finishroleids"));
/*  597 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.InstanceCacheBean {
/*      */     private Const() {}
/*      */     
/*      */     InstanceCacheBean nThis() {
/*  604 */       return InstanceCacheBean.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  610 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InstanceCacheBean copy()
/*      */     {
/*  616 */       return InstanceCacheBean.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InstanceCacheBean toData()
/*      */     {
/*  622 */       return InstanceCacheBean.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.InstanceCacheBean toBean()
/*      */     {
/*  627 */       return InstanceCacheBean.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InstanceCacheBean toDataIf()
/*      */     {
/*  633 */       return InstanceCacheBean.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.InstanceCacheBean toBeanIf()
/*      */     {
/*  638 */       return InstanceCacheBean.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getInstancecfgid()
/*      */     {
/*  645 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  646 */       return InstanceCacheBean.this.instancecfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorldid()
/*      */     {
/*  653 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  654 */       return InstanceCacheBean.this.worldid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpentime()
/*      */     {
/*  661 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  662 */       return InstanceCacheBean.this.opentime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleids()
/*      */     {
/*  669 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  670 */       return xdb.Consts.constList(InstanceCacheBean.this.roleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getRoleidsAsData()
/*      */     {
/*  676 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*      */       
/*  678 */       InstanceCacheBean _o_ = InstanceCacheBean.this;
/*  679 */       List<Long> roleids = new ArrayList();
/*  680 */       roleids.addAll(_o_.roleids);
/*  681 */       return roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getSucroleids()
/*      */     {
/*  688 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  689 */       return xdb.Consts.constList(InstanceCacheBean.this.sucroleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getSucroleidsAsData()
/*      */     {
/*  695 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*      */       
/*  697 */       InstanceCacheBean _o_ = InstanceCacheBean.this;
/*  698 */       List<Long> sucroleids = new ArrayList();
/*  699 */       sucroleids.addAll(_o_.sucroleids);
/*  700 */       return sucroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtra()
/*      */     {
/*  707 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  708 */       return xdb.Consts.constMap(InstanceCacheBean.this.extra);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtraAsData()
/*      */     {
/*  715 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*      */       
/*  717 */       InstanceCacheBean _o_ = InstanceCacheBean.this;
/*  718 */       Map<Integer, Integer> extra = new HashMap();
/*  719 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*  720 */         extra.put(_e_.getKey(), _e_.getValue());
/*  721 */       return extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFinishroleids()
/*      */     {
/*  728 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  729 */       return xdb.Consts.constSet(InstanceCacheBean.this.finishroleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getFinishroleidsAsData()
/*      */     {
/*  735 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*      */       
/*  737 */       InstanceCacheBean _o_ = InstanceCacheBean.this;
/*  738 */       Set<Long> finishroleids = new SetX();
/*  739 */       finishroleids.addAll(_o_.finishroleids);
/*  740 */       return finishroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInstancecfgid(int _v_)
/*      */     {
/*  747 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  748 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorldid(long _v_)
/*      */     {
/*  755 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  756 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpentime(long _v_)
/*      */     {
/*  763 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  764 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  770 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  771 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  777 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  778 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  784 */       return InstanceCacheBean.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  790 */       return InstanceCacheBean.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  796 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  797 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  803 */       return InstanceCacheBean.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  809 */       return InstanceCacheBean.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  815 */       InstanceCacheBean.this._xdb_verify_unsafe_();
/*  816 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  822 */       return InstanceCacheBean.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  828 */       return InstanceCacheBean.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  834 */       return InstanceCacheBean.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  840 */       return InstanceCacheBean.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  846 */       return InstanceCacheBean.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  852 */       return InstanceCacheBean.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  858 */       return InstanceCacheBean.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.InstanceCacheBean
/*      */   {
/*      */     private int instancecfgid;
/*      */     
/*      */     private long worldid;
/*      */     
/*      */     private long opentime;
/*      */     
/*      */     private ArrayList<Long> roleids;
/*      */     
/*      */     private ArrayList<Long> sucroleids;
/*      */     
/*      */     private HashMap<Integer, Integer> extra;
/*      */     
/*      */     private HashSet<Long> finishroleids;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  882 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  887 */       this.roleids = new ArrayList();
/*  888 */       this.sucroleids = new ArrayList();
/*  889 */       this.extra = new HashMap();
/*  890 */       this.finishroleids = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.InstanceCacheBean _o1_)
/*      */     {
/*  895 */       if ((_o1_ instanceof InstanceCacheBean)) { assign((InstanceCacheBean)_o1_);
/*  896 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  897 */       } else if ((_o1_ instanceof InstanceCacheBean.Const)) assign(((InstanceCacheBean.Const)_o1_).nThis()); else {
/*  898 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(InstanceCacheBean _o_) {
/*  903 */       this.instancecfgid = _o_.instancecfgid;
/*  904 */       this.worldid = _o_.worldid;
/*  905 */       this.opentime = _o_.opentime;
/*  906 */       this.roleids = new ArrayList();
/*  907 */       this.roleids.addAll(_o_.roleids);
/*  908 */       this.sucroleids = new ArrayList();
/*  909 */       this.sucroleids.addAll(_o_.sucroleids);
/*  910 */       this.extra = new HashMap();
/*  911 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*  912 */         this.extra.put(_e_.getKey(), _e_.getValue());
/*  913 */       this.finishroleids = new HashSet();
/*  914 */       this.finishroleids.addAll(_o_.finishroleids);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  919 */       this.instancecfgid = _o_.instancecfgid;
/*  920 */       this.worldid = _o_.worldid;
/*  921 */       this.opentime = _o_.opentime;
/*  922 */       this.roleids = new ArrayList();
/*  923 */       this.roleids.addAll(_o_.roleids);
/*  924 */       this.sucroleids = new ArrayList();
/*  925 */       this.sucroleids.addAll(_o_.sucroleids);
/*  926 */       this.extra = new HashMap();
/*  927 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*  928 */         this.extra.put(_e_.getKey(), _e_.getValue());
/*  929 */       this.finishroleids = new HashSet();
/*  930 */       this.finishroleids.addAll(_o_.finishroleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  936 */       _os_.marshal(this.instancecfgid);
/*  937 */       _os_.marshal(this.worldid);
/*  938 */       _os_.marshal(this.opentime);
/*  939 */       _os_.compact_uint32(this.roleids.size());
/*  940 */       for (Long _v_ : this.roleids)
/*      */       {
/*  942 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  944 */       _os_.compact_uint32(this.sucroleids.size());
/*  945 */       for (Long _v_ : this.sucroleids)
/*      */       {
/*  947 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  949 */       _os_.compact_uint32(this.extra.size());
/*  950 */       for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */       {
/*  952 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  953 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  955 */       _os_.compact_uint32(this.finishroleids.size());
/*  956 */       for (Long _v_ : this.finishroleids)
/*      */       {
/*  958 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  960 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  966 */       this.instancecfgid = _os_.unmarshal_int();
/*  967 */       this.worldid = _os_.unmarshal_long();
/*  968 */       this.opentime = _os_.unmarshal_long();
/*  969 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  971 */         long _v_ = 0L;
/*  972 */         _v_ = _os_.unmarshal_long();
/*  973 */         this.roleids.add(Long.valueOf(_v_));
/*      */       }
/*  975 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  977 */         long _v_ = 0L;
/*  978 */         _v_ = _os_.unmarshal_long();
/*  979 */         this.sucroleids.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/*  982 */       int size = _os_.uncompact_uint32();
/*  983 */       if (size >= 12)
/*      */       {
/*  985 */         this.extra = new HashMap(size * 2);
/*      */       }
/*  987 */       for (; size > 0; size--)
/*      */       {
/*  989 */         int _k_ = 0;
/*  990 */         _k_ = _os_.unmarshal_int();
/*  991 */         int _v_ = 0;
/*  992 */         _v_ = _os_.unmarshal_int();
/*  993 */         this.extra.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  996 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  998 */         long _v_ = 0L;
/*  999 */         _v_ = _os_.unmarshal_long();
/* 1000 */         this.finishroleids.add(Long.valueOf(_v_));
/*      */       }
/* 1002 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1008 */       int _size_ = 0;
/* 1009 */       _size_ += CodedOutputStream.computeInt32Size(1, this.instancecfgid);
/* 1010 */       _size_ += CodedOutputStream.computeInt64Size(2, this.worldid);
/* 1011 */       _size_ += CodedOutputStream.computeInt64Size(3, this.opentime);
/* 1012 */       for (Long _v_ : this.roleids)
/*      */       {
/* 1014 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/* 1016 */       for (Long _v_ : this.sucroleids)
/*      */       {
/* 1018 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/* 1020 */       for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */       {
/* 1022 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1023 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1025 */       for (Long _v_ : this.finishroleids)
/*      */       {
/* 1027 */         _size_ += CodedOutputStream.computeInt64Size(7, _v_.longValue());
/*      */       }
/* 1029 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1037 */         _output_.writeInt32(1, this.instancecfgid);
/* 1038 */         _output_.writeInt64(2, this.worldid);
/* 1039 */         _output_.writeInt64(3, this.opentime);
/* 1040 */         for (Long _v_ : this.roleids)
/*      */         {
/* 1042 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/* 1044 */         for (Long _v_ : this.sucroleids)
/*      */         {
/* 1046 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/* 1048 */         for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */         {
/* 1050 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1051 */           _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1053 */         for (Long _v_ : this.finishroleids)
/*      */         {
/* 1055 */           _output_.writeInt64(7, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1060 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1062 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1070 */         boolean done = false;
/* 1071 */         while (!done)
/*      */         {
/* 1073 */           int tag = _input_.readTag();
/* 1074 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1078 */             done = true;
/* 1079 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1083 */             this.instancecfgid = _input_.readInt32();
/* 1084 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1088 */             this.worldid = _input_.readInt64();
/* 1089 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1093 */             this.opentime = _input_.readInt64();
/* 1094 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1098 */             long _v_ = 0L;
/* 1099 */             _v_ = _input_.readInt64();
/* 1100 */             this.roleids.add(Long.valueOf(_v_));
/* 1101 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1105 */             long _v_ = 0L;
/* 1106 */             _v_ = _input_.readInt64();
/* 1107 */             this.sucroleids.add(Long.valueOf(_v_));
/* 1108 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1112 */             int _k_ = 0;
/* 1113 */             _k_ = _input_.readInt32();
/* 1114 */             int readTag = _input_.readTag();
/* 1115 */             if (48 != readTag)
/*      */             {
/* 1117 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1119 */             int _v_ = 0;
/* 1120 */             _v_ = _input_.readInt32();
/* 1121 */             this.extra.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1122 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1126 */             long _v_ = 0L;
/* 1127 */             _v_ = _input_.readInt64();
/* 1128 */             this.finishroleids.add(Long.valueOf(_v_));
/* 1129 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1133 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1135 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1144 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1148 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1150 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InstanceCacheBean copy()
/*      */     {
/* 1156 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InstanceCacheBean toData()
/*      */     {
/* 1162 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.InstanceCacheBean toBean()
/*      */     {
/* 1167 */       return new InstanceCacheBean(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InstanceCacheBean toDataIf()
/*      */     {
/* 1173 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.InstanceCacheBean toBeanIf()
/*      */     {
/* 1178 */       return new InstanceCacheBean(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1184 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1188 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1192 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1196 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1200 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1204 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1208 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getInstancecfgid()
/*      */     {
/* 1215 */       return this.instancecfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorldid()
/*      */     {
/* 1222 */       return this.worldid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpentime()
/*      */     {
/* 1229 */       return this.opentime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleids()
/*      */     {
/* 1236 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleidsAsData()
/*      */     {
/* 1243 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getSucroleids()
/*      */     {
/* 1250 */       return this.sucroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getSucroleidsAsData()
/*      */     {
/* 1257 */       return this.sucroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtra()
/*      */     {
/* 1264 */       return this.extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtraAsData()
/*      */     {
/* 1271 */       return this.extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFinishroleids()
/*      */     {
/* 1278 */       return this.finishroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFinishroleidsAsData()
/*      */     {
/* 1285 */       return this.finishroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInstancecfgid(int _v_)
/*      */     {
/* 1292 */       this.instancecfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorldid(long _v_)
/*      */     {
/* 1299 */       this.worldid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpentime(long _v_)
/*      */     {
/* 1306 */       this.opentime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1312 */       if (!(_o1_ instanceof Data)) return false;
/* 1313 */       Data _o_ = (Data)_o1_;
/* 1314 */       if (this.instancecfgid != _o_.instancecfgid) return false;
/* 1315 */       if (this.worldid != _o_.worldid) return false;
/* 1316 */       if (this.opentime != _o_.opentime) return false;
/* 1317 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 1318 */       if (!this.sucroleids.equals(_o_.sucroleids)) return false;
/* 1319 */       if (!this.extra.equals(_o_.extra)) return false;
/* 1320 */       if (!this.finishroleids.equals(_o_.finishroleids)) return false;
/* 1321 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1327 */       int _h_ = 0;
/* 1328 */       _h_ += this.instancecfgid;
/* 1329 */       _h_ = (int)(_h_ + this.worldid);
/* 1330 */       _h_ = (int)(_h_ + this.opentime);
/* 1331 */       _h_ += this.roleids.hashCode();
/* 1332 */       _h_ += this.sucroleids.hashCode();
/* 1333 */       _h_ += this.extra.hashCode();
/* 1334 */       _h_ += this.finishroleids.hashCode();
/* 1335 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1341 */       StringBuilder _sb_ = new StringBuilder();
/* 1342 */       _sb_.append("(");
/* 1343 */       _sb_.append(this.instancecfgid);
/* 1344 */       _sb_.append(",");
/* 1345 */       _sb_.append(this.worldid);
/* 1346 */       _sb_.append(",");
/* 1347 */       _sb_.append(this.opentime);
/* 1348 */       _sb_.append(",");
/* 1349 */       _sb_.append(this.roleids);
/* 1350 */       _sb_.append(",");
/* 1351 */       _sb_.append(this.sucroleids);
/* 1352 */       _sb_.append(",");
/* 1353 */       _sb_.append(this.extra);
/* 1354 */       _sb_.append(",");
/* 1355 */       _sb_.append(this.finishroleids);
/* 1356 */       _sb_.append(")");
/* 1357 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\InstanceCacheBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */