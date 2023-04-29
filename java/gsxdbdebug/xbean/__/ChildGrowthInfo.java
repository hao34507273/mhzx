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
/*      */ public final class ChildGrowthInfo extends XBean implements xbean.ChildGrowthInfo
/*      */ {
/*      */   private int grow_type;
/*      */   private long grow_time;
/*      */   private HashMap<Integer, Integer> int_parameter_map;
/*      */   private HashMap<Integer, String> string_parameter_map;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.grow_type = 0;
/*   25 */     this.grow_time = 0L;
/*   26 */     this.int_parameter_map.clear();
/*   27 */     this.string_parameter_map.clear();
/*      */   }
/*      */   
/*      */   ChildGrowthInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.int_parameter_map = new HashMap();
/*   34 */     this.string_parameter_map = new HashMap();
/*      */   }
/*      */   
/*      */   public ChildGrowthInfo()
/*      */   {
/*   39 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ChildGrowthInfo(ChildGrowthInfo _o_)
/*      */   {
/*   44 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ChildGrowthInfo(xbean.ChildGrowthInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   49 */     super(_xp_, _vn_);
/*   50 */     if ((_o1_ instanceof ChildGrowthInfo)) { assign((ChildGrowthInfo)_o1_);
/*   51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   53 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ChildGrowthInfo _o_) {
/*   58 */     _o_._xdb_verify_unsafe_();
/*   59 */     this.grow_type = _o_.grow_type;
/*   60 */     this.grow_time = _o_.grow_time;
/*   61 */     this.int_parameter_map = new HashMap();
/*   62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.int_parameter_map.entrySet())
/*   63 */       this.int_parameter_map.put(_e_.getKey(), _e_.getValue());
/*   64 */     this.string_parameter_map = new HashMap();
/*   65 */     for (Map.Entry<Integer, String> _e_ : _o_.string_parameter_map.entrySet()) {
/*   66 */       this.string_parameter_map.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   71 */     this.grow_type = _o_.grow_type;
/*   72 */     this.grow_time = _o_.grow_time;
/*   73 */     this.int_parameter_map = new HashMap();
/*   74 */     for (Map.Entry<Integer, Integer> _e_ : _o_.int_parameter_map.entrySet())
/*   75 */       this.int_parameter_map.put(_e_.getKey(), _e_.getValue());
/*   76 */     this.string_parameter_map = new HashMap();
/*   77 */     for (Map.Entry<Integer, String> _e_ : _o_.string_parameter_map.entrySet()) {
/*   78 */       this.string_parameter_map.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.grow_type);
/*   86 */     _os_.marshal(this.grow_time);
/*   87 */     _os_.compact_uint32(this.int_parameter_map.size());
/*   88 */     for (Map.Entry<Integer, Integer> _e_ : this.int_parameter_map.entrySet())
/*      */     {
/*   90 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   91 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   93 */     _os_.compact_uint32(this.string_parameter_map.size());
/*   94 */     for (Map.Entry<Integer, String> _e_ : this.string_parameter_map.entrySet())
/*      */     {
/*   96 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   97 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */     }
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.grow_type = _os_.unmarshal_int();
/*  107 */     this.grow_time = _os_.unmarshal_long();
/*      */     
/*  109 */     int size = _os_.uncompact_uint32();
/*  110 */     if (size >= 12)
/*      */     {
/*  112 */       this.int_parameter_map = new HashMap(size * 2);
/*      */     }
/*  114 */     for (; size > 0; size--)
/*      */     {
/*  116 */       int _k_ = 0;
/*  117 */       _k_ = _os_.unmarshal_int();
/*  118 */       int _v_ = 0;
/*  119 */       _v_ = _os_.unmarshal_int();
/*  120 */       this.int_parameter_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  124 */     int size = _os_.uncompact_uint32();
/*  125 */     if (size >= 12)
/*      */     {
/*  127 */       this.string_parameter_map = new HashMap(size * 2);
/*      */     }
/*  129 */     for (; size > 0; size--)
/*      */     {
/*  131 */       int _k_ = 0;
/*  132 */       _k_ = _os_.unmarshal_int();
/*  133 */       String _v_ = "";
/*  134 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  135 */       this.string_parameter_map.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  138 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     int _size_ = 0;
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(1, this.grow_type);
/*  147 */     _size_ += CodedOutputStream.computeInt64Size(2, this.grow_time);
/*  148 */     for (Map.Entry<Integer, Integer> _e_ : this.int_parameter_map.entrySet())
/*      */     {
/*  150 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  151 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  153 */     for (Map.Entry<Integer, String> _e_ : this.string_parameter_map.entrySet())
/*      */     {
/*  155 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*      */       try
/*      */       {
/*  158 */         _size_ += CodedOutputStream.computeBytesSize(4, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  162 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  165 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  174 */       _output_.writeInt32(1, this.grow_type);
/*  175 */       _output_.writeInt64(2, this.grow_time);
/*  176 */       for (Map.Entry<Integer, Integer> _e_ : this.int_parameter_map.entrySet())
/*      */       {
/*  178 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  179 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  181 */       for (Map.Entry<Integer, String> _e_ : this.string_parameter_map.entrySet())
/*      */       {
/*  183 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  184 */         _output_.writeBytes(4, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  189 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  191 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  197 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  200 */       boolean done = false;
/*  201 */       while (!done)
/*      */       {
/*  203 */         int tag = _input_.readTag();
/*  204 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  208 */           done = true;
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  213 */           this.grow_type = _input_.readInt32();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  218 */           this.grow_time = _input_.readInt64();
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  223 */           int _k_ = 0;
/*  224 */           _k_ = _input_.readInt32();
/*  225 */           int readTag = _input_.readTag();
/*  226 */           if (24 != readTag)
/*      */           {
/*  228 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  230 */           int _v_ = 0;
/*  231 */           _v_ = _input_.readInt32();
/*  232 */           this.int_parameter_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  233 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  237 */           int _k_ = 0;
/*  238 */           _k_ = _input_.readInt32();
/*  239 */           int readTag = _input_.readTag();
/*  240 */           if (34 != readTag)
/*      */           {
/*  242 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  244 */           String _v_ = "";
/*  245 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  246 */           this.string_parameter_map.put(Integer.valueOf(_k_), _v_);
/*  247 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  251 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  253 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  262 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  266 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  268 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildGrowthInfo copy()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new ChildGrowthInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildGrowthInfo toData()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChildGrowthInfo toBean()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new ChildGrowthInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildGrowthInfo toDataIf()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChildGrowthInfo toBeanIf()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGrow_type()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return this.grow_type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGrow_time()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.grow_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getInt_parameter_map()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return xdb.Logs.logMap(new LogKey(this, "int_parameter_map"), this.int_parameter_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getInt_parameter_mapAsData()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*      */     
/*  341 */     ChildGrowthInfo _o_ = this;
/*  342 */     Map<Integer, Integer> int_parameter_map = new HashMap();
/*  343 */     for (Map.Entry<Integer, Integer> _e_ : _o_.int_parameter_map.entrySet())
/*  344 */       int_parameter_map.put(_e_.getKey(), _e_.getValue());
/*  345 */     return int_parameter_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, String> getString_parameter_map()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return xdb.Logs.logMap(new LogKey(this, "string_parameter_map"), this.string_parameter_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, String> getString_parameter_mapAsData()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*      */     
/*  362 */     ChildGrowthInfo _o_ = this;
/*  363 */     Map<Integer, String> string_parameter_map = new HashMap();
/*  364 */     for (Map.Entry<Integer, String> _e_ : _o_.string_parameter_map.entrySet())
/*  365 */       string_parameter_map.put(_e_.getKey(), _e_.getValue());
/*  366 */     return string_parameter_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrow_type(int _v_)
/*      */   {
/*  373 */     _xdb_verify_unsafe_();
/*  374 */     xdb.Logs.logIf(new LogKey(this, "grow_type")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  378 */         new xdb.logs.LogInt(this, ChildGrowthInfo.this.grow_type)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  382 */             ChildGrowthInfo.this.grow_type = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  386 */     });
/*  387 */     this.grow_type = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrow_time(long _v_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     xdb.Logs.logIf(new LogKey(this, "grow_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  399 */         new xdb.logs.LogLong(this, ChildGrowthInfo.this.grow_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  403 */             ChildGrowthInfo.this.grow_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  407 */     });
/*  408 */     this.grow_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     ChildGrowthInfo _o_ = null;
/*  416 */     if ((_o1_ instanceof ChildGrowthInfo)) { _o_ = (ChildGrowthInfo)_o1_;
/*  417 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  418 */       return false;
/*  419 */     if (this.grow_type != _o_.grow_type) return false;
/*  420 */     if (this.grow_time != _o_.grow_time) return false;
/*  421 */     if (!this.int_parameter_map.equals(_o_.int_parameter_map)) return false;
/*  422 */     if (!this.string_parameter_map.equals(_o_.string_parameter_map)) return false;
/*  423 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  429 */     _xdb_verify_unsafe_();
/*  430 */     int _h_ = 0;
/*  431 */     _h_ += this.grow_type;
/*  432 */     _h_ = (int)(_h_ + this.grow_time);
/*  433 */     _h_ += this.int_parameter_map.hashCode();
/*  434 */     _h_ += this.string_parameter_map.hashCode();
/*  435 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  441 */     _xdb_verify_unsafe_();
/*  442 */     StringBuilder _sb_ = new StringBuilder();
/*  443 */     _sb_.append("(");
/*  444 */     _sb_.append(this.grow_type);
/*  445 */     _sb_.append(",");
/*  446 */     _sb_.append(this.grow_time);
/*  447 */     _sb_.append(",");
/*  448 */     _sb_.append(this.int_parameter_map);
/*  449 */     _sb_.append(",");
/*  450 */     _sb_.append(this.string_parameter_map);
/*  451 */     _sb_.append(")");
/*  452 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  458 */     ListenableBean lb = new ListenableBean();
/*  459 */     lb.add(new xdb.logs.ListenableChanged().setVarName("grow_type"));
/*  460 */     lb.add(new xdb.logs.ListenableChanged().setVarName("grow_time"));
/*  461 */     lb.add(new xdb.logs.ListenableMap().setVarName("int_parameter_map"));
/*  462 */     lb.add(new xdb.logs.ListenableMap().setVarName("string_parameter_map"));
/*  463 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ChildGrowthInfo {
/*      */     private Const() {}
/*      */     
/*      */     ChildGrowthInfo nThis() {
/*  470 */       return ChildGrowthInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  476 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthInfo copy()
/*      */     {
/*  482 */       return ChildGrowthInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthInfo toData()
/*      */     {
/*  488 */       return ChildGrowthInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ChildGrowthInfo toBean()
/*      */     {
/*  493 */       return ChildGrowthInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthInfo toDataIf()
/*      */     {
/*  499 */       return ChildGrowthInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ChildGrowthInfo toBeanIf()
/*      */     {
/*  504 */       return ChildGrowthInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGrow_type()
/*      */     {
/*  511 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  512 */       return ChildGrowthInfo.this.grow_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrow_time()
/*      */     {
/*  519 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  520 */       return ChildGrowthInfo.this.grow_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getInt_parameter_map()
/*      */     {
/*  527 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  528 */       return xdb.Consts.constMap(ChildGrowthInfo.this.int_parameter_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getInt_parameter_mapAsData()
/*      */     {
/*  535 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*      */       
/*  537 */       ChildGrowthInfo _o_ = ChildGrowthInfo.this;
/*  538 */       Map<Integer, Integer> int_parameter_map = new HashMap();
/*  539 */       for (Map.Entry<Integer, Integer> _e_ : _o_.int_parameter_map.entrySet())
/*  540 */         int_parameter_map.put(_e_.getKey(), _e_.getValue());
/*  541 */       return int_parameter_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getString_parameter_map()
/*      */     {
/*  548 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  549 */       return xdb.Consts.constMap(ChildGrowthInfo.this.string_parameter_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getString_parameter_mapAsData()
/*      */     {
/*  556 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*      */       
/*  558 */       ChildGrowthInfo _o_ = ChildGrowthInfo.this;
/*  559 */       Map<Integer, String> string_parameter_map = new HashMap();
/*  560 */       for (Map.Entry<Integer, String> _e_ : _o_.string_parameter_map.entrySet())
/*  561 */         string_parameter_map.put(_e_.getKey(), _e_.getValue());
/*  562 */       return string_parameter_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrow_type(int _v_)
/*      */     {
/*  569 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  570 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrow_time(long _v_)
/*      */     {
/*  577 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  578 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  584 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  585 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  591 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  592 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  598 */       return ChildGrowthInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  604 */       return ChildGrowthInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  610 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  611 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  617 */       return ChildGrowthInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  623 */       return ChildGrowthInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  629 */       ChildGrowthInfo.this._xdb_verify_unsafe_();
/*  630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  636 */       return ChildGrowthInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  642 */       return ChildGrowthInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  648 */       return ChildGrowthInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  654 */       return ChildGrowthInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  660 */       return ChildGrowthInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  666 */       return ChildGrowthInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  672 */       return ChildGrowthInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ChildGrowthInfo
/*      */   {
/*      */     private int grow_type;
/*      */     
/*      */     private long grow_time;
/*      */     
/*      */     private HashMap<Integer, Integer> int_parameter_map;
/*      */     
/*      */     private HashMap<Integer, String> string_parameter_map;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  690 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  695 */       this.int_parameter_map = new HashMap();
/*  696 */       this.string_parameter_map = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.ChildGrowthInfo _o1_)
/*      */     {
/*  701 */       if ((_o1_ instanceof ChildGrowthInfo)) { assign((ChildGrowthInfo)_o1_);
/*  702 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  703 */       } else if ((_o1_ instanceof ChildGrowthInfo.Const)) assign(((ChildGrowthInfo.Const)_o1_).nThis()); else {
/*  704 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ChildGrowthInfo _o_) {
/*  709 */       this.grow_type = _o_.grow_type;
/*  710 */       this.grow_time = _o_.grow_time;
/*  711 */       this.int_parameter_map = new HashMap();
/*  712 */       for (Map.Entry<Integer, Integer> _e_ : _o_.int_parameter_map.entrySet())
/*  713 */         this.int_parameter_map.put(_e_.getKey(), _e_.getValue());
/*  714 */       this.string_parameter_map = new HashMap();
/*  715 */       for (Map.Entry<Integer, String> _e_ : _o_.string_parameter_map.entrySet()) {
/*  716 */         this.string_parameter_map.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  721 */       this.grow_type = _o_.grow_type;
/*  722 */       this.grow_time = _o_.grow_time;
/*  723 */       this.int_parameter_map = new HashMap();
/*  724 */       for (Map.Entry<Integer, Integer> _e_ : _o_.int_parameter_map.entrySet())
/*  725 */         this.int_parameter_map.put(_e_.getKey(), _e_.getValue());
/*  726 */       this.string_parameter_map = new HashMap();
/*  727 */       for (Map.Entry<Integer, String> _e_ : _o_.string_parameter_map.entrySet()) {
/*  728 */         this.string_parameter_map.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  734 */       _os_.marshal(this.grow_type);
/*  735 */       _os_.marshal(this.grow_time);
/*  736 */       _os_.compact_uint32(this.int_parameter_map.size());
/*  737 */       for (Map.Entry<Integer, Integer> _e_ : this.int_parameter_map.entrySet())
/*      */       {
/*  739 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  740 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  742 */       _os_.compact_uint32(this.string_parameter_map.size());
/*  743 */       for (Map.Entry<Integer, String> _e_ : this.string_parameter_map.entrySet())
/*      */       {
/*  745 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  746 */         _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */       }
/*  748 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  754 */       this.grow_type = _os_.unmarshal_int();
/*  755 */       this.grow_time = _os_.unmarshal_long();
/*      */       
/*  757 */       int size = _os_.uncompact_uint32();
/*  758 */       if (size >= 12)
/*      */       {
/*  760 */         this.int_parameter_map = new HashMap(size * 2);
/*      */       }
/*  762 */       for (; size > 0; size--)
/*      */       {
/*  764 */         int _k_ = 0;
/*  765 */         _k_ = _os_.unmarshal_int();
/*  766 */         int _v_ = 0;
/*  767 */         _v_ = _os_.unmarshal_int();
/*  768 */         this.int_parameter_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/*  772 */       int size = _os_.uncompact_uint32();
/*  773 */       if (size >= 12)
/*      */       {
/*  775 */         this.string_parameter_map = new HashMap(size * 2);
/*      */       }
/*  777 */       for (; size > 0; size--)
/*      */       {
/*  779 */         int _k_ = 0;
/*  780 */         _k_ = _os_.unmarshal_int();
/*  781 */         String _v_ = "";
/*  782 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/*  783 */         this.string_parameter_map.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  786 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  792 */       int _size_ = 0;
/*  793 */       _size_ += CodedOutputStream.computeInt32Size(1, this.grow_type);
/*  794 */       _size_ += CodedOutputStream.computeInt64Size(2, this.grow_time);
/*  795 */       for (Map.Entry<Integer, Integer> _e_ : this.int_parameter_map.entrySet())
/*      */       {
/*  797 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  798 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  800 */       for (Map.Entry<Integer, String> _e_ : this.string_parameter_map.entrySet())
/*      */       {
/*  802 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*      */         try
/*      */         {
/*  805 */           _size_ += CodedOutputStream.computeBytesSize(4, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */         catch (java.io.UnsupportedEncodingException e)
/*      */         {
/*  809 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/*  812 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  820 */         _output_.writeInt32(1, this.grow_type);
/*  821 */         _output_.writeInt64(2, this.grow_time);
/*  822 */         for (Map.Entry<Integer, Integer> _e_ : this.int_parameter_map.entrySet())
/*      */         {
/*  824 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  825 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  827 */         for (Map.Entry<Integer, String> _e_ : this.string_parameter_map.entrySet())
/*      */         {
/*  829 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  830 */           _output_.writeBytes(4, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  835 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  837 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  845 */         boolean done = false;
/*  846 */         while (!done)
/*      */         {
/*  848 */           int tag = _input_.readTag();
/*  849 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  853 */             done = true;
/*  854 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  858 */             this.grow_type = _input_.readInt32();
/*  859 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  863 */             this.grow_time = _input_.readInt64();
/*  864 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  868 */             int _k_ = 0;
/*  869 */             _k_ = _input_.readInt32();
/*  870 */             int readTag = _input_.readTag();
/*  871 */             if (24 != readTag)
/*      */             {
/*  873 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  875 */             int _v_ = 0;
/*  876 */             _v_ = _input_.readInt32();
/*  877 */             this.int_parameter_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  878 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  882 */             int _k_ = 0;
/*  883 */             _k_ = _input_.readInt32();
/*  884 */             int readTag = _input_.readTag();
/*  885 */             if (34 != readTag)
/*      */             {
/*  887 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  889 */             String _v_ = "";
/*  890 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/*  891 */             this.string_parameter_map.put(Integer.valueOf(_k_), _v_);
/*  892 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  896 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  898 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  907 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  911 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  913 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthInfo copy()
/*      */     {
/*  919 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthInfo toData()
/*      */     {
/*  925 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ChildGrowthInfo toBean()
/*      */     {
/*  930 */       return new ChildGrowthInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthInfo toDataIf()
/*      */     {
/*  936 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ChildGrowthInfo toBeanIf()
/*      */     {
/*  941 */       return new ChildGrowthInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  955 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  959 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  963 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  967 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  971 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGrow_type()
/*      */     {
/*  978 */       return this.grow_type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrow_time()
/*      */     {
/*  985 */       return this.grow_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getInt_parameter_map()
/*      */     {
/*  992 */       return this.int_parameter_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getInt_parameter_mapAsData()
/*      */     {
/*  999 */       return this.int_parameter_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getString_parameter_map()
/*      */     {
/* 1006 */       return this.string_parameter_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getString_parameter_mapAsData()
/*      */     {
/* 1013 */       return this.string_parameter_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrow_type(int _v_)
/*      */     {
/* 1020 */       this.grow_type = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrow_time(long _v_)
/*      */     {
/* 1027 */       this.grow_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1033 */       if (!(_o1_ instanceof Data)) return false;
/* 1034 */       Data _o_ = (Data)_o1_;
/* 1035 */       if (this.grow_type != _o_.grow_type) return false;
/* 1036 */       if (this.grow_time != _o_.grow_time) return false;
/* 1037 */       if (!this.int_parameter_map.equals(_o_.int_parameter_map)) return false;
/* 1038 */       if (!this.string_parameter_map.equals(_o_.string_parameter_map)) return false;
/* 1039 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1045 */       int _h_ = 0;
/* 1046 */       _h_ += this.grow_type;
/* 1047 */       _h_ = (int)(_h_ + this.grow_time);
/* 1048 */       _h_ += this.int_parameter_map.hashCode();
/* 1049 */       _h_ += this.string_parameter_map.hashCode();
/* 1050 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1056 */       StringBuilder _sb_ = new StringBuilder();
/* 1057 */       _sb_.append("(");
/* 1058 */       _sb_.append(this.grow_type);
/* 1059 */       _sb_.append(",");
/* 1060 */       _sb_.append(this.grow_time);
/* 1061 */       _sb_.append(",");
/* 1062 */       _sb_.append(this.int_parameter_map);
/* 1063 */       _sb_.append(",");
/* 1064 */       _sb_.append(this.string_parameter_map);
/* 1065 */       _sb_.append(")");
/* 1066 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChildGrowthInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */