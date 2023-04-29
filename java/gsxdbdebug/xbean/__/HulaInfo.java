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
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ 
/*      */ public final class HulaInfo extends XBean implements xbean.HulaInfo
/*      */ {
/*      */   private int point;
/*      */   private HashMap<Integer, Integer> delete_type_2_count;
/*      */   private HashMap<Integer, Integer> kill_monsterid_2_count;
/*      */   private long worldid;
/*      */   private HashMap<Integer, Integer> delete_monsterid_2_count;
/*      */   private int turnpoint;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.point = 0;
/*   29 */     this.delete_type_2_count.clear();
/*   30 */     this.kill_monsterid_2_count.clear();
/*   31 */     this.worldid = 0L;
/*   32 */     this.delete_monsterid_2_count.clear();
/*   33 */     this.turnpoint = 0;
/*      */   }
/*      */   
/*      */   HulaInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.delete_type_2_count = new HashMap();
/*   40 */     this.kill_monsterid_2_count = new HashMap();
/*   41 */     this.delete_monsterid_2_count = new HashMap();
/*      */   }
/*      */   
/*      */   public HulaInfo()
/*      */   {
/*   46 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public HulaInfo(HulaInfo _o_)
/*      */   {
/*   51 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   HulaInfo(xbean.HulaInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     if ((_o1_ instanceof HulaInfo)) { assign((HulaInfo)_o1_);
/*   58 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   59 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   60 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(HulaInfo _o_) {
/*   65 */     _o_._xdb_verify_unsafe_();
/*   66 */     this.point = _o_.point;
/*   67 */     this.delete_type_2_count = new HashMap();
/*   68 */     for (Map.Entry<Integer, Integer> _e_ : _o_.delete_type_2_count.entrySet())
/*   69 */       this.delete_type_2_count.put(_e_.getKey(), _e_.getValue());
/*   70 */     this.kill_monsterid_2_count = new HashMap();
/*   71 */     for (Map.Entry<Integer, Integer> _e_ : _o_.kill_monsterid_2_count.entrySet())
/*   72 */       this.kill_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*   73 */     this.worldid = _o_.worldid;
/*   74 */     this.delete_monsterid_2_count = new HashMap();
/*   75 */     for (Map.Entry<Integer, Integer> _e_ : _o_.delete_monsterid_2_count.entrySet())
/*   76 */       this.delete_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*   77 */     this.turnpoint = _o_.turnpoint;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   82 */     this.point = _o_.point;
/*   83 */     this.delete_type_2_count = new HashMap();
/*   84 */     for (Map.Entry<Integer, Integer> _e_ : _o_.delete_type_2_count.entrySet())
/*   85 */       this.delete_type_2_count.put(_e_.getKey(), _e_.getValue());
/*   86 */     this.kill_monsterid_2_count = new HashMap();
/*   87 */     for (Map.Entry<Integer, Integer> _e_ : _o_.kill_monsterid_2_count.entrySet())
/*   88 */       this.kill_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*   89 */     this.worldid = _o_.worldid;
/*   90 */     this.delete_monsterid_2_count = new HashMap();
/*   91 */     for (Map.Entry<Integer, Integer> _e_ : _o_.delete_monsterid_2_count.entrySet())
/*   92 */       this.delete_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*   93 */     this.turnpoint = _o_.turnpoint;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     _os_.marshal(this.point);
/*  101 */     _os_.compact_uint32(this.delete_type_2_count.size());
/*  102 */     for (Map.Entry<Integer, Integer> _e_ : this.delete_type_2_count.entrySet())
/*      */     {
/*  104 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  105 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  107 */     _os_.compact_uint32(this.kill_monsterid_2_count.size());
/*  108 */     for (Map.Entry<Integer, Integer> _e_ : this.kill_monsterid_2_count.entrySet())
/*      */     {
/*  110 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  111 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  113 */     _os_.marshal(this.worldid);
/*  114 */     _os_.compact_uint32(this.delete_monsterid_2_count.size());
/*  115 */     for (Map.Entry<Integer, Integer> _e_ : this.delete_monsterid_2_count.entrySet())
/*      */     {
/*  117 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  118 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  120 */     _os_.marshal(this.turnpoint);
/*  121 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  127 */     _xdb_verify_unsafe_();
/*  128 */     this.point = _os_.unmarshal_int();
/*      */     
/*  130 */     int size = _os_.uncompact_uint32();
/*  131 */     if (size >= 12)
/*      */     {
/*  133 */       this.delete_type_2_count = new HashMap(size * 2);
/*      */     }
/*  135 */     for (; size > 0; size--)
/*      */     {
/*  137 */       int _k_ = 0;
/*  138 */       _k_ = _os_.unmarshal_int();
/*  139 */       int _v_ = 0;
/*  140 */       _v_ = _os_.unmarshal_int();
/*  141 */       this.delete_type_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  145 */     int size = _os_.uncompact_uint32();
/*  146 */     if (size >= 12)
/*      */     {
/*  148 */       this.kill_monsterid_2_count = new HashMap(size * 2);
/*      */     }
/*  150 */     for (; size > 0; size--)
/*      */     {
/*  152 */       int _k_ = 0;
/*  153 */       _k_ = _os_.unmarshal_int();
/*  154 */       int _v_ = 0;
/*  155 */       _v_ = _os_.unmarshal_int();
/*  156 */       this.kill_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  159 */     this.worldid = _os_.unmarshal_long();
/*      */     
/*  161 */     int size = _os_.uncompact_uint32();
/*  162 */     if (size >= 12)
/*      */     {
/*  164 */       this.delete_monsterid_2_count = new HashMap(size * 2);
/*      */     }
/*  166 */     for (; size > 0; size--)
/*      */     {
/*  168 */       int _k_ = 0;
/*  169 */       _k_ = _os_.unmarshal_int();
/*  170 */       int _v_ = 0;
/*  171 */       _v_ = _os_.unmarshal_int();
/*  172 */       this.delete_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  175 */     this.turnpoint = _os_.unmarshal_int();
/*  176 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  182 */     _xdb_verify_unsafe_();
/*  183 */     int _size_ = 0;
/*  184 */     _size_ += CodedOutputStream.computeInt32Size(1, this.point);
/*  185 */     for (Map.Entry<Integer, Integer> _e_ : this.delete_type_2_count.entrySet())
/*      */     {
/*  187 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  188 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  190 */     for (Map.Entry<Integer, Integer> _e_ : this.kill_monsterid_2_count.entrySet())
/*      */     {
/*  192 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  193 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  195 */     _size_ += CodedOutputStream.computeInt64Size(4, this.worldid);
/*  196 */     for (Map.Entry<Integer, Integer> _e_ : this.delete_monsterid_2_count.entrySet())
/*      */     {
/*  198 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  199 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  201 */     _size_ += CodedOutputStream.computeInt32Size(6, this.turnpoint);
/*  202 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  208 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  211 */       _output_.writeInt32(1, this.point);
/*  212 */       for (Map.Entry<Integer, Integer> _e_ : this.delete_type_2_count.entrySet())
/*      */       {
/*  214 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  215 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  217 */       for (Map.Entry<Integer, Integer> _e_ : this.kill_monsterid_2_count.entrySet())
/*      */       {
/*  219 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  220 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  222 */       _output_.writeInt64(4, this.worldid);
/*  223 */       for (Map.Entry<Integer, Integer> _e_ : this.delete_monsterid_2_count.entrySet())
/*      */       {
/*  225 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  226 */         _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  228 */       _output_.writeInt32(6, this.turnpoint);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  232 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  234 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  243 */       boolean done = false;
/*  244 */       while (!done)
/*      */       {
/*  246 */         int tag = _input_.readTag();
/*  247 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  251 */           done = true;
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  256 */           this.point = _input_.readInt32();
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  261 */           int _k_ = 0;
/*  262 */           _k_ = _input_.readInt32();
/*  263 */           int readTag = _input_.readTag();
/*  264 */           if (16 != readTag)
/*      */           {
/*  266 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  268 */           int _v_ = 0;
/*  269 */           _v_ = _input_.readInt32();
/*  270 */           this.delete_type_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  271 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  275 */           int _k_ = 0;
/*  276 */           _k_ = _input_.readInt32();
/*  277 */           int readTag = _input_.readTag();
/*  278 */           if (24 != readTag)
/*      */           {
/*  280 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  282 */           int _v_ = 0;
/*  283 */           _v_ = _input_.readInt32();
/*  284 */           this.kill_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  285 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  289 */           this.worldid = _input_.readInt64();
/*  290 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  294 */           int _k_ = 0;
/*  295 */           _k_ = _input_.readInt32();
/*  296 */           int readTag = _input_.readTag();
/*  297 */           if (40 != readTag)
/*      */           {
/*  299 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  301 */           int _v_ = 0;
/*  302 */           _v_ = _input_.readInt32();
/*  303 */           this.delete_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  304 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  308 */           this.turnpoint = _input_.readInt32();
/*  309 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  313 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  315 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  324 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  328 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  330 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HulaInfo copy()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return new HulaInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HulaInfo toData()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.HulaInfo toBean()
/*      */   {
/*  349 */     _xdb_verify_unsafe_();
/*  350 */     return new HulaInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HulaInfo toDataIf()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.HulaInfo toBeanIf()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPoint()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return this.point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getDelete_type_2_count()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return xdb.Logs.logMap(new LogKey(this, "delete_type_2_count"), this.delete_type_2_count);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getDelete_type_2_countAsData()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*      */     
/*  395 */     HulaInfo _o_ = this;
/*  396 */     Map<Integer, Integer> delete_type_2_count = new HashMap();
/*  397 */     for (Map.Entry<Integer, Integer> _e_ : _o_.delete_type_2_count.entrySet())
/*  398 */       delete_type_2_count.put(_e_.getKey(), _e_.getValue());
/*  399 */     return delete_type_2_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getKill_monsterid_2_count()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return xdb.Logs.logMap(new LogKey(this, "kill_monsterid_2_count"), this.kill_monsterid_2_count);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getKill_monsterid_2_countAsData()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*      */     
/*  416 */     HulaInfo _o_ = this;
/*  417 */     Map<Integer, Integer> kill_monsterid_2_count = new HashMap();
/*  418 */     for (Map.Entry<Integer, Integer> _e_ : _o_.kill_monsterid_2_count.entrySet())
/*  419 */       kill_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*  420 */     return kill_monsterid_2_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWorldid()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return this.worldid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getDelete_monsterid_2_count()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     return xdb.Logs.logMap(new LogKey(this, "delete_monsterid_2_count"), this.delete_monsterid_2_count);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getDelete_monsterid_2_countAsData()
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*      */     
/*  445 */     HulaInfo _o_ = this;
/*  446 */     Map<Integer, Integer> delete_monsterid_2_count = new HashMap();
/*  447 */     for (Map.Entry<Integer, Integer> _e_ : _o_.delete_monsterid_2_count.entrySet())
/*  448 */       delete_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*  449 */     return delete_monsterid_2_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTurnpoint()
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     return this.turnpoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPoint(int _v_)
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     xdb.Logs.logIf(new LogKey(this, "point")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  469 */         new xdb.logs.LogInt(this, HulaInfo.this.point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  473 */             HulaInfo.this.point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  477 */     });
/*  478 */     this.point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWorldid(long _v_)
/*      */   {
/*  485 */     _xdb_verify_unsafe_();
/*  486 */     xdb.Logs.logIf(new LogKey(this, "worldid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  490 */         new xdb.logs.LogLong(this, HulaInfo.this.worldid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  494 */             HulaInfo.this.worldid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  498 */     });
/*  499 */     this.worldid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTurnpoint(int _v_)
/*      */   {
/*  506 */     _xdb_verify_unsafe_();
/*  507 */     xdb.Logs.logIf(new LogKey(this, "turnpoint")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  511 */         new xdb.logs.LogInt(this, HulaInfo.this.turnpoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  515 */             HulaInfo.this.turnpoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  519 */     });
/*  520 */     this.turnpoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  526 */     _xdb_verify_unsafe_();
/*  527 */     HulaInfo _o_ = null;
/*  528 */     if ((_o1_ instanceof HulaInfo)) { _o_ = (HulaInfo)_o1_;
/*  529 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  530 */       return false;
/*  531 */     if (this.point != _o_.point) return false;
/*  532 */     if (!this.delete_type_2_count.equals(_o_.delete_type_2_count)) return false;
/*  533 */     if (!this.kill_monsterid_2_count.equals(_o_.kill_monsterid_2_count)) return false;
/*  534 */     if (this.worldid != _o_.worldid) return false;
/*  535 */     if (!this.delete_monsterid_2_count.equals(_o_.delete_monsterid_2_count)) return false;
/*  536 */     if (this.turnpoint != _o_.turnpoint) return false;
/*  537 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  543 */     _xdb_verify_unsafe_();
/*  544 */     int _h_ = 0;
/*  545 */     _h_ += this.point;
/*  546 */     _h_ += this.delete_type_2_count.hashCode();
/*  547 */     _h_ += this.kill_monsterid_2_count.hashCode();
/*  548 */     _h_ = (int)(_h_ + this.worldid);
/*  549 */     _h_ += this.delete_monsterid_2_count.hashCode();
/*  550 */     _h_ += this.turnpoint;
/*  551 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  557 */     _xdb_verify_unsafe_();
/*  558 */     StringBuilder _sb_ = new StringBuilder();
/*  559 */     _sb_.append("(");
/*  560 */     _sb_.append(this.point);
/*  561 */     _sb_.append(",");
/*  562 */     _sb_.append(this.delete_type_2_count);
/*  563 */     _sb_.append(",");
/*  564 */     _sb_.append(this.kill_monsterid_2_count);
/*  565 */     _sb_.append(",");
/*  566 */     _sb_.append(this.worldid);
/*  567 */     _sb_.append(",");
/*  568 */     _sb_.append(this.delete_monsterid_2_count);
/*  569 */     _sb_.append(",");
/*  570 */     _sb_.append(this.turnpoint);
/*  571 */     _sb_.append(")");
/*  572 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  578 */     ListenableBean lb = new ListenableBean();
/*  579 */     lb.add(new ListenableChanged().setVarName("point"));
/*  580 */     lb.add(new ListenableMap().setVarName("delete_type_2_count"));
/*  581 */     lb.add(new ListenableMap().setVarName("kill_monsterid_2_count"));
/*  582 */     lb.add(new ListenableChanged().setVarName("worldid"));
/*  583 */     lb.add(new ListenableMap().setVarName("delete_monsterid_2_count"));
/*  584 */     lb.add(new ListenableChanged().setVarName("turnpoint"));
/*  585 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.HulaInfo {
/*      */     private Const() {}
/*      */     
/*      */     HulaInfo nThis() {
/*  592 */       return HulaInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  598 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HulaInfo copy()
/*      */     {
/*  604 */       return HulaInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HulaInfo toData()
/*      */     {
/*  610 */       return HulaInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.HulaInfo toBean()
/*      */     {
/*  615 */       return HulaInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HulaInfo toDataIf()
/*      */     {
/*  621 */       return HulaInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.HulaInfo toBeanIf()
/*      */     {
/*  626 */       return HulaInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPoint()
/*      */     {
/*  633 */       HulaInfo.this._xdb_verify_unsafe_();
/*  634 */       return HulaInfo.this.point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getDelete_type_2_count()
/*      */     {
/*  641 */       HulaInfo.this._xdb_verify_unsafe_();
/*  642 */       return xdb.Consts.constMap(HulaInfo.this.delete_type_2_count);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getDelete_type_2_countAsData()
/*      */     {
/*  649 */       HulaInfo.this._xdb_verify_unsafe_();
/*      */       
/*  651 */       HulaInfo _o_ = HulaInfo.this;
/*  652 */       Map<Integer, Integer> delete_type_2_count = new HashMap();
/*  653 */       for (Map.Entry<Integer, Integer> _e_ : _o_.delete_type_2_count.entrySet())
/*  654 */         delete_type_2_count.put(_e_.getKey(), _e_.getValue());
/*  655 */       return delete_type_2_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getKill_monsterid_2_count()
/*      */     {
/*  662 */       HulaInfo.this._xdb_verify_unsafe_();
/*  663 */       return xdb.Consts.constMap(HulaInfo.this.kill_monsterid_2_count);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getKill_monsterid_2_countAsData()
/*      */     {
/*  670 */       HulaInfo.this._xdb_verify_unsafe_();
/*      */       
/*  672 */       HulaInfo _o_ = HulaInfo.this;
/*  673 */       Map<Integer, Integer> kill_monsterid_2_count = new HashMap();
/*  674 */       for (Map.Entry<Integer, Integer> _e_ : _o_.kill_monsterid_2_count.entrySet())
/*  675 */         kill_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*  676 */       return kill_monsterid_2_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorldid()
/*      */     {
/*  683 */       HulaInfo.this._xdb_verify_unsafe_();
/*  684 */       return HulaInfo.this.worldid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getDelete_monsterid_2_count()
/*      */     {
/*  691 */       HulaInfo.this._xdb_verify_unsafe_();
/*  692 */       return xdb.Consts.constMap(HulaInfo.this.delete_monsterid_2_count);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getDelete_monsterid_2_countAsData()
/*      */     {
/*  699 */       HulaInfo.this._xdb_verify_unsafe_();
/*      */       
/*  701 */       HulaInfo _o_ = HulaInfo.this;
/*  702 */       Map<Integer, Integer> delete_monsterid_2_count = new HashMap();
/*  703 */       for (Map.Entry<Integer, Integer> _e_ : _o_.delete_monsterid_2_count.entrySet())
/*  704 */         delete_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*  705 */       return delete_monsterid_2_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTurnpoint()
/*      */     {
/*  712 */       HulaInfo.this._xdb_verify_unsafe_();
/*  713 */       return HulaInfo.this.turnpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPoint(int _v_)
/*      */     {
/*  720 */       HulaInfo.this._xdb_verify_unsafe_();
/*  721 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorldid(long _v_)
/*      */     {
/*  728 */       HulaInfo.this._xdb_verify_unsafe_();
/*  729 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTurnpoint(int _v_)
/*      */     {
/*  736 */       HulaInfo.this._xdb_verify_unsafe_();
/*  737 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  743 */       HulaInfo.this._xdb_verify_unsafe_();
/*  744 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  750 */       HulaInfo.this._xdb_verify_unsafe_();
/*  751 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  757 */       return HulaInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  763 */       return HulaInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  769 */       HulaInfo.this._xdb_verify_unsafe_();
/*  770 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  776 */       return HulaInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  782 */       return HulaInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  788 */       HulaInfo.this._xdb_verify_unsafe_();
/*  789 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  795 */       return HulaInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  801 */       return HulaInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  807 */       return HulaInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  813 */       return HulaInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  819 */       return HulaInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  825 */       return HulaInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  831 */       return HulaInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.HulaInfo
/*      */   {
/*      */     private int point;
/*      */     
/*      */     private HashMap<Integer, Integer> delete_type_2_count;
/*      */     
/*      */     private HashMap<Integer, Integer> kill_monsterid_2_count;
/*      */     
/*      */     private long worldid;
/*      */     
/*      */     private HashMap<Integer, Integer> delete_monsterid_2_count;
/*      */     
/*      */     private int turnpoint;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  853 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  858 */       this.delete_type_2_count = new HashMap();
/*  859 */       this.kill_monsterid_2_count = new HashMap();
/*  860 */       this.delete_monsterid_2_count = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.HulaInfo _o1_)
/*      */     {
/*  865 */       if ((_o1_ instanceof HulaInfo)) { assign((HulaInfo)_o1_);
/*  866 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  867 */       } else if ((_o1_ instanceof HulaInfo.Const)) assign(((HulaInfo.Const)_o1_).nThis()); else {
/*  868 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(HulaInfo _o_) {
/*  873 */       this.point = _o_.point;
/*  874 */       this.delete_type_2_count = new HashMap();
/*  875 */       for (Map.Entry<Integer, Integer> _e_ : _o_.delete_type_2_count.entrySet())
/*  876 */         this.delete_type_2_count.put(_e_.getKey(), _e_.getValue());
/*  877 */       this.kill_monsterid_2_count = new HashMap();
/*  878 */       for (Map.Entry<Integer, Integer> _e_ : _o_.kill_monsterid_2_count.entrySet())
/*  879 */         this.kill_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*  880 */       this.worldid = _o_.worldid;
/*  881 */       this.delete_monsterid_2_count = new HashMap();
/*  882 */       for (Map.Entry<Integer, Integer> _e_ : _o_.delete_monsterid_2_count.entrySet())
/*  883 */         this.delete_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*  884 */       this.turnpoint = _o_.turnpoint;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  889 */       this.point = _o_.point;
/*  890 */       this.delete_type_2_count = new HashMap();
/*  891 */       for (Map.Entry<Integer, Integer> _e_ : _o_.delete_type_2_count.entrySet())
/*  892 */         this.delete_type_2_count.put(_e_.getKey(), _e_.getValue());
/*  893 */       this.kill_monsterid_2_count = new HashMap();
/*  894 */       for (Map.Entry<Integer, Integer> _e_ : _o_.kill_monsterid_2_count.entrySet())
/*  895 */         this.kill_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*  896 */       this.worldid = _o_.worldid;
/*  897 */       this.delete_monsterid_2_count = new HashMap();
/*  898 */       for (Map.Entry<Integer, Integer> _e_ : _o_.delete_monsterid_2_count.entrySet())
/*  899 */         this.delete_monsterid_2_count.put(_e_.getKey(), _e_.getValue());
/*  900 */       this.turnpoint = _o_.turnpoint;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  906 */       _os_.marshal(this.point);
/*  907 */       _os_.compact_uint32(this.delete_type_2_count.size());
/*  908 */       for (Map.Entry<Integer, Integer> _e_ : this.delete_type_2_count.entrySet())
/*      */       {
/*  910 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  911 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  913 */       _os_.compact_uint32(this.kill_monsterid_2_count.size());
/*  914 */       for (Map.Entry<Integer, Integer> _e_ : this.kill_monsterid_2_count.entrySet())
/*      */       {
/*  916 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  917 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  919 */       _os_.marshal(this.worldid);
/*  920 */       _os_.compact_uint32(this.delete_monsterid_2_count.size());
/*  921 */       for (Map.Entry<Integer, Integer> _e_ : this.delete_monsterid_2_count.entrySet())
/*      */       {
/*  923 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  924 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  926 */       _os_.marshal(this.turnpoint);
/*  927 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  933 */       this.point = _os_.unmarshal_int();
/*      */       
/*  935 */       int size = _os_.uncompact_uint32();
/*  936 */       if (size >= 12)
/*      */       {
/*  938 */         this.delete_type_2_count = new HashMap(size * 2);
/*      */       }
/*  940 */       for (; size > 0; size--)
/*      */       {
/*  942 */         int _k_ = 0;
/*  943 */         _k_ = _os_.unmarshal_int();
/*  944 */         int _v_ = 0;
/*  945 */         _v_ = _os_.unmarshal_int();
/*  946 */         this.delete_type_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/*  950 */       int size = _os_.uncompact_uint32();
/*  951 */       if (size >= 12)
/*      */       {
/*  953 */         this.kill_monsterid_2_count = new HashMap(size * 2);
/*      */       }
/*  955 */       for (; size > 0; size--)
/*      */       {
/*  957 */         int _k_ = 0;
/*  958 */         _k_ = _os_.unmarshal_int();
/*  959 */         int _v_ = 0;
/*  960 */         _v_ = _os_.unmarshal_int();
/*  961 */         this.kill_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  964 */       this.worldid = _os_.unmarshal_long();
/*      */       
/*  966 */       int size = _os_.uncompact_uint32();
/*  967 */       if (size >= 12)
/*      */       {
/*  969 */         this.delete_monsterid_2_count = new HashMap(size * 2);
/*      */       }
/*  971 */       for (; size > 0; size--)
/*      */       {
/*  973 */         int _k_ = 0;
/*  974 */         _k_ = _os_.unmarshal_int();
/*  975 */         int _v_ = 0;
/*  976 */         _v_ = _os_.unmarshal_int();
/*  977 */         this.delete_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  980 */       this.turnpoint = _os_.unmarshal_int();
/*  981 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  987 */       int _size_ = 0;
/*  988 */       _size_ += CodedOutputStream.computeInt32Size(1, this.point);
/*  989 */       for (Map.Entry<Integer, Integer> _e_ : this.delete_type_2_count.entrySet())
/*      */       {
/*  991 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  992 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  994 */       for (Map.Entry<Integer, Integer> _e_ : this.kill_monsterid_2_count.entrySet())
/*      */       {
/*  996 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  997 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  999 */       _size_ += CodedOutputStream.computeInt64Size(4, this.worldid);
/* 1000 */       for (Map.Entry<Integer, Integer> _e_ : this.delete_monsterid_2_count.entrySet())
/*      */       {
/* 1002 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/* 1003 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1005 */       _size_ += CodedOutputStream.computeInt32Size(6, this.turnpoint);
/* 1006 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1014 */         _output_.writeInt32(1, this.point);
/* 1015 */         for (Map.Entry<Integer, Integer> _e_ : this.delete_type_2_count.entrySet())
/*      */         {
/* 1017 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 1018 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1020 */         for (Map.Entry<Integer, Integer> _e_ : this.kill_monsterid_2_count.entrySet())
/*      */         {
/* 1022 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 1023 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1025 */         _output_.writeInt64(4, this.worldid);
/* 1026 */         for (Map.Entry<Integer, Integer> _e_ : this.delete_monsterid_2_count.entrySet())
/*      */         {
/* 1028 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/* 1029 */           _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1031 */         _output_.writeInt32(6, this.turnpoint);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1035 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1037 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1045 */         boolean done = false;
/* 1046 */         while (!done)
/*      */         {
/* 1048 */           int tag = _input_.readTag();
/* 1049 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1053 */             done = true;
/* 1054 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1058 */             this.point = _input_.readInt32();
/* 1059 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1063 */             int _k_ = 0;
/* 1064 */             _k_ = _input_.readInt32();
/* 1065 */             int readTag = _input_.readTag();
/* 1066 */             if (16 != readTag)
/*      */             {
/* 1068 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1070 */             int _v_ = 0;
/* 1071 */             _v_ = _input_.readInt32();
/* 1072 */             this.delete_type_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1073 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1077 */             int _k_ = 0;
/* 1078 */             _k_ = _input_.readInt32();
/* 1079 */             int readTag = _input_.readTag();
/* 1080 */             if (24 != readTag)
/*      */             {
/* 1082 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1084 */             int _v_ = 0;
/* 1085 */             _v_ = _input_.readInt32();
/* 1086 */             this.kill_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1087 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1091 */             this.worldid = _input_.readInt64();
/* 1092 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1096 */             int _k_ = 0;
/* 1097 */             _k_ = _input_.readInt32();
/* 1098 */             int readTag = _input_.readTag();
/* 1099 */             if (40 != readTag)
/*      */             {
/* 1101 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1103 */             int _v_ = 0;
/* 1104 */             _v_ = _input_.readInt32();
/* 1105 */             this.delete_monsterid_2_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1106 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1110 */             this.turnpoint = _input_.readInt32();
/* 1111 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1115 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1117 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1126 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1130 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1132 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HulaInfo copy()
/*      */     {
/* 1138 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HulaInfo toData()
/*      */     {
/* 1144 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.HulaInfo toBean()
/*      */     {
/* 1149 */       return new HulaInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HulaInfo toDataIf()
/*      */     {
/* 1155 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.HulaInfo toBeanIf()
/*      */     {
/* 1160 */       return new HulaInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1166 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1170 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1174 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1178 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1182 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1186 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1190 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPoint()
/*      */     {
/* 1197 */       return this.point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getDelete_type_2_count()
/*      */     {
/* 1204 */       return this.delete_type_2_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getDelete_type_2_countAsData()
/*      */     {
/* 1211 */       return this.delete_type_2_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getKill_monsterid_2_count()
/*      */     {
/* 1218 */       return this.kill_monsterid_2_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getKill_monsterid_2_countAsData()
/*      */     {
/* 1225 */       return this.kill_monsterid_2_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorldid()
/*      */     {
/* 1232 */       return this.worldid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getDelete_monsterid_2_count()
/*      */     {
/* 1239 */       return this.delete_monsterid_2_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getDelete_monsterid_2_countAsData()
/*      */     {
/* 1246 */       return this.delete_monsterid_2_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTurnpoint()
/*      */     {
/* 1253 */       return this.turnpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPoint(int _v_)
/*      */     {
/* 1260 */       this.point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorldid(long _v_)
/*      */     {
/* 1267 */       this.worldid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTurnpoint(int _v_)
/*      */     {
/* 1274 */       this.turnpoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1280 */       if (!(_o1_ instanceof Data)) return false;
/* 1281 */       Data _o_ = (Data)_o1_;
/* 1282 */       if (this.point != _o_.point) return false;
/* 1283 */       if (!this.delete_type_2_count.equals(_o_.delete_type_2_count)) return false;
/* 1284 */       if (!this.kill_monsterid_2_count.equals(_o_.kill_monsterid_2_count)) return false;
/* 1285 */       if (this.worldid != _o_.worldid) return false;
/* 1286 */       if (!this.delete_monsterid_2_count.equals(_o_.delete_monsterid_2_count)) return false;
/* 1287 */       if (this.turnpoint != _o_.turnpoint) return false;
/* 1288 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1294 */       int _h_ = 0;
/* 1295 */       _h_ += this.point;
/* 1296 */       _h_ += this.delete_type_2_count.hashCode();
/* 1297 */       _h_ += this.kill_monsterid_2_count.hashCode();
/* 1298 */       _h_ = (int)(_h_ + this.worldid);
/* 1299 */       _h_ += this.delete_monsterid_2_count.hashCode();
/* 1300 */       _h_ += this.turnpoint;
/* 1301 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1307 */       StringBuilder _sb_ = new StringBuilder();
/* 1308 */       _sb_.append("(");
/* 1309 */       _sb_.append(this.point);
/* 1310 */       _sb_.append(",");
/* 1311 */       _sb_.append(this.delete_type_2_count);
/* 1312 */       _sb_.append(",");
/* 1313 */       _sb_.append(this.kill_monsterid_2_count);
/* 1314 */       _sb_.append(",");
/* 1315 */       _sb_.append(this.worldid);
/* 1316 */       _sb_.append(",");
/* 1317 */       _sb_.append(this.delete_monsterid_2_count);
/* 1318 */       _sb_.append(",");
/* 1319 */       _sb_.append(this.turnpoint);
/* 1320 */       _sb_.append(")");
/* 1321 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HulaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */